//DARAGH DOWNES
//STUDENT ID : 22351159


public class Image {
        private int[][] pixels;
        private int width;
        private int height;

        public Image(int[][] pixels) {

            this.pixels = pixels;

            this.height = pixels.length;

            this.width = pixels[0].length;

        }

    public String toString() {
        int row, col;
        String array = "";
        for (col = 0, row = 0; col < width && row < height; ) {
            array = array + pixels[row][col];
            if (col == width - 1) {
                array = array + "\n";
                col = 0;
                row++;
            } else {
                col++;
            }
        }
        return array;
    }

        public void flip(boolean horizontal){
            if(horizontal){
                for(int row = 0; row<this.height; row++){
                    for(int col=0; col<this.width/2; col++){
                        int temp = this.pixels[row][col];
                        this.pixels[row][col] =  this.pixels[row][this.width-1 -col];
                        this.pixels[row][this.width -1 - col] = temp;
                    }
                }
            }
            else{
                for(int i = 0; i<this.height/2; i++){
                    for(int j=0; j<this.width; j++){
                        int temp = this.pixels[i][j];
                        this.pixels[i][j] =  this.pixels[this.width-1-i][j];
                        this.pixels[this.width-1-i][j] = temp;

                    }
                }
            }

        }
    public void rotate(boolean clockwise){
        int[][] newArr = new int[width][height];
        if(clockwise){
            for(int row = 0; row<this.height; row++){
                for(int col=0; col<this.width; col++){
                    newArr[col][height-1-row] = pixels[row][col];
                }
            }
        }
        else {
            for(int row = 0; row<this.height; row++){
                for(int col=0; col<this.width; col++){
                    newArr[width-1-col][row] = pixels[row][col];
                }
            }
        }
        pixels = newArr;
        this.height = pixels.length; //since the dimensions change after rotating we need to update it so our string method still works, this then lets the string method work on non square arrays
        this.width = pixels[0].length;

    }

    }

