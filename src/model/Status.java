package model;

public class Status {
    private String errorMessage;
    private double myXCoord;
    private double myYCoord;
    private double myHeading;

    public Status() {
        errorMessage = "";
        myXCoord = 0;
        myYCoord = 0;
        myHeading = 0;
    }
    public String getErrorMessage () {
        return errorMessage;
    }

    public void setErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public double getMyXCoord () {
        return myXCoord;
    }

    public void setMyXCoord (double myXCoord) {
        this.myXCoord = myXCoord;
    }

    public double getMyYCoord () {
        return myYCoord;
    }

    public void setMyYCoord (double myYCoord) {
        this.myYCoord = myYCoord;
    }

    public double getMyHeading () {
        return myHeading;
    }

    public void setMyHeading (double myHeading) {
        this.myHeading = myHeading;
    }



}
