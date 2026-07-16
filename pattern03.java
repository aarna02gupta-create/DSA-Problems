public class pattern03 {
    public static void main(String args[]) {
        int n=5;
        for(int row = 0; row < n; row++) {  //outer loop for rows
         for(int i = 0; i< n - row - 1; i++)
            System.out.print(" ");
         for(int i = 0; i< 2*row + 1; i++)
            System.out.print("*");
        
         System.out.println();
    }}}  
    

/*public class pattern03 {
    public static void main(String args[]) {
        int n=5;
        for(int row = 0; row < n; row++){
           for(int i=0; i<row; i++)
            System.out.print(" ");
           for(int i=0; i< 2*(n-row) - 1; i++)
            System.out.print("*");
    
           System.out.println();
        }}} */
        
