import java.util.Scanner;


  public   class Retangle {
        float length;
        float width;

        public Retangle(float length, float width) {
            this.length = length;
            this.width = width;
        }

        public void lenth() {
            System.out.printf("The lengh is:" + length);
            System.out.println();
        }
        public void width() {
            System.out.printf("The width is:"+width);
            System.out.println();
        }
        public void say() {
            System.out.printf("The area is:"+width * length);
        }
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          float v1 = scanner.nextFloat();
          System.out.println("Please input length:");
          float v2 = scanner.nextFloat();
          System.out.println("Please input width:");
          Retangle retangle = new Retangle(v1, v2);
          retangle.lenth();
          retangle.width();
          retangle.say();

      }
    }



