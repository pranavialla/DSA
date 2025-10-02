

public class rotateMatrixTo90 {
    public void rotate(int[][] image) {
        transposeImage(image);

        // reverse each row of the image
        for(int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[row].length - 1;
            while(i < j) {
                int tmp = image[row][i];
                image[row][i++] = image[row][j];
                image[row][j--] = tmp;
            }
        }
    }

    // Turns rows into cols and vice versa
    private void transposeImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            for(int j = i + 1; j < image[i].length; j++) {
                int tmp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = tmp;
            }
        }
    }
}
