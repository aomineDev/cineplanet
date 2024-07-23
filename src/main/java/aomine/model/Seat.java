package aomine.model;

public class Seat {
  private int seatId;
  private int roomNumber;
  private String[][] seatMatrix = {
    {"V", "E", "E", "E", "E", "E", "V", "V", "V", "V", "V", "V", "E", "E", "E", "E", "V", "V", "V"},
    {"V", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "V", "V", "V"},
    {"V", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "V", "V", "V"},
    {"V", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "V", "V", "V"},
    {"V", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
    {"V", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
    {"V", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
    {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
  };

  public Seat (int seatId, int roomNumber) {
    this.seatId = seatId;
    this.roomNumber = roomNumber;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
  
  public int getSeatId() {
    return seatId;
  }

  public String[][] getSeatMatrix() {
    return seatMatrix;
  }

  public void updateSeatsSelected(int row, int column) {
    this.seatMatrix[row][column] = "O";
  }
}
