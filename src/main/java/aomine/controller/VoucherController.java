package aomine.controller;

import javafx.scene.Node;
import javafx.scene.image.WritableImage;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import aomine.store.Store;
import aomine.model.Seat;
import aomine.model.Voucher;
import aomine.service.SeatService;
import aomine.service.VoucherService;

public class VoucherController {
  private Store store;
  private SeatService seatService;
  private VoucherService voucherService;  
  private ArrayList<String> selectedSeats;

  public VoucherController() {
    store = Store.getInstance();
    seatService = new SeatService();
    voucherService = new VoucherService();
    selectedSeats = store.getSelectedSeats();
  }

  public String getStoreSelectedSeats() {
    return store.getSelectedSeatsToString();
  }

  public String getStoreMovieTitle() {
    return store.getMovie().getTitle();
  }

  public String getStoreDate() {
    return store.getDate();
  }

  public String getStoreTime() {
    return store.getShowTime().getFormattedTime();
  }

  public String getStoreRoomNumber() {
    return "sala " + store.getRoomNumber();
  }

  public String getStoreFormat() {
    return store.getFormat() + " General";
  }

  public String getStoreQunatity() {
    return selectedSeats.size() + "";
  }

  public String getStoreticketPrice() {
    double ticketPrice = store.getTicketPrice();
    return store.getMovie().getFormatedTicketPrice(ticketPrice);
  }

  public String getTotalPrice() {
    double totalPrice =  store.getTicketPrice() * selectedSeats.size();

    return store.getMovie().getFormatedTicketPrice(totalPrice);
  }

  public void setOccupiedSeats() {
    int seatId = store.getShowTime().getSeatId();
    Seat seat = seatService.getById(seatId);

    for (String seatPos: selectedSeats) {
      int rowIndex = store.getSelectedSeatRowIndex(seatPos);
      int columnIndex = store.getSelectedSeatColumnIndex(seatPos);
      
      seat.updateSeatsSelected(rowIndex, columnIndex);
    }

    selectedSeats.clear();
  }

  public void createVoucher(String clientName) {
    voucherService.create(new Voucher(
      clientName,
      getStoreMovieTitle(), 
      getStoreFormat(), 
      getStoreDate(), 
      getStoreTime(), 
      selectedSeats, 
      store.getTicketPrice(), 
      store.getRoomNumber()
    ));
  }

  private WritableImage captureView(Node view) {
    WritableImage image = new WritableImage((int) view.getBoundsInParent().getWidth(), (int) view.getBoundsInParent().getHeight());
    view.snapshot(null, image);

    return image;
  }

  public void saveAsPng(Node view, String filePath) throws IOException {
    WritableImage image = captureView(view);
    File file = new File(filePath + ".png");
    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
  }

  public void saveAsPdf(Node view, String filePath) throws IOException {
    WritableImage image = captureView(view);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputStream);
    byte[] imageBytes = outputStream.toByteArray();

    ImageData data = ImageDataFactory.create(imageBytes);
    Image pdfImage = new Image(data);

    PdfWriter writer = new PdfWriter(filePath + ".pdf");
    PdfDocument pdfDoc = new PdfDocument(writer);
    Document document = new Document(pdfDoc);

    document.add(pdfImage);
    document.close();
  }
}
