package com.company;

public class Wall {
    private Brick[][] bricks;

    //    public Brick(int row, int column) throws Exception{
//        wall = new int[row][column];
//

//    }

//    private String [][] Seats;
//    public MovieSeating(int rowNum, int columnNum)
//    {
//        Seats = new String[rowNum][columnNum];
//        for (int r = 0; r < rowNum; r++)
//        {
//            for (int c = 0; c < columnNum; c++)
//            {
//                Seats[r][c] = "???";
//            }
//        }
//    }

    public Wall(int row, int column) {
        bricks = new Brick[row][column];
        generateBricks(row, column);
//        for(int i=0; i<row; i++){
//            for(int j=0;j<column;j++){
//                int brickWidth = 500/column;
//                int brickHeight = 150/row;
//                bricks[i][j] = new Brick(i, j, brickWidth, brickHeight, true);
//            }
//        }
    }

    public void generateBricks(int row, int column) {
        for(int i=0; i<row; i++){
            for(int j=0;j<column;j++){
                int brickWidth = 500/column;
                int brickHeight = 150/row;
                this.bricks[i][j] = new Brick(i, j, brickWidth, brickHeight, true);
            }
        }
    }

    public Brick[][] getBricksRows() {
        return bricks;
    }

    public Brick[] getBricksColumns() {
        return bricks[0];
    }
}
