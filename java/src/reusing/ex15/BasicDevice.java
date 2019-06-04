package reusing.ex15;

          public class BasicDevice {
              private String s = "Original";

              public BasicDevice() {
                  s = "Original";
              }

              protected void changeS(String c) { // outside package, only derived
                  s = c;            // classes can access protected method
              }

              public void showS() {
                  System.out.println(s);
              }
          }