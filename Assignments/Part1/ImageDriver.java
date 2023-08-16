//DARAGH DOWNES
//STUDENT ID : 22351159

import java.util.Random;
public class ImageDriver {
    static int[][] GenerateArray(int width,int height){//generates array with random values
        Random rand = new Random();
        int array[][] = new int[height][width];
        int row,col;
        for(row = 0,col=0; row <height;){
            array[row][col]=rand.nextInt(10);
            if(col == width-1){
                col =0 ;
                row++;

            }
            else{
                col++;
            }
        }
        return array;
    }
    public static void main(String[]args){

        int[][] myarray = GenerateArray(5,5);
        Image myimage = new Image(myarray);
        System.out.println("This is the array before it is modified");
        System.out.println(myimage);
        myimage.flip(false);
        System.out.println("\n");
        System.out.println("This is the array after it is modified- flip vertical");
        System.out.println(myimage);

        int[][] myarray1 = GenerateArray(5,5);
        Image image2 = new Image(myarray1);
        System.out.println("This is the array before it is modified");
        System.out.println(image2);
        image2.flip(true);
        System.out.println("\n");
        System.out.println("This is the array after it is modified- flip horizontal");
        System.out.println(image2);

        int[][] myarray2 = GenerateArray(5,5);
        Image image3 = new Image(myarray2);
        System.out.println("This is the array before it is modified");
        System.out.println(image3);
        image3.rotate(true);
        System.out.println("\n");
        System.out.println("This is the array after it is modified-rotate clockwise");
        System.out.println(image3);

        int[][] myarray3 = GenerateArray(10,5);
        Image image4 = new Image(myarray3);
        System.out.println("This is the array before it is modified");
        System.out.println(image4);
        image4.rotate(false);
        System.out.println("\n");
        System.out.println("This is the array after it is modified-rotate anti clockwise");
        System.out.println(image4);

        int[][] myarrayx = GenerateArray(5,10);
        Image imagex = new Image(myarrayx);
        System.out.println("This is the array before it is modified");
        System.out.println(imagex);
        imagex.rotate(true);
        imagex.flip(true);//flipping clockwise and horizontal
        System.out.println("\n");
        System.out.println("This is the array after it is modified-rotate clockwise and flip horizontal");
        System.out.println(imagex);

    }

}
