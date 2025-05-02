public class CheckDigit 
{   
  /** Returns the check digit for num, as described in part (a).  
   *  Precondition: The number of digits in num is between one and    
   *  six, inclusive.  
   *          num >= 0  
   */  
  public static int getCheck(int num){
    int digits = getNumberOfDigits(num);
    int sum = 0;
    for (int i = 1; i <= digits; i++)
    {
      int weight = 8 - i;           
      sum += getDigit(num, i) * weight;
    }
    return sum % 10;         
  }
  
  public static boolean isValid(int numWithCheckDigit)
  {
    int checkDigit = numWithCheckDigit % 10;
    int num = numWithCheckDigit / 10;
    return getCheck(num) == checkDigit;
  }

   
   /** Returns the number of digits in num. */    
   public static int getNumberOfDigits(int num)    
   {      
    if(num < 10)
      return 1;
    return 1 + getNumberOfDigits(num/10);    
   }    
   
   /** Returns the nthdigit of num.      
    *  Precondition: n >= 1 and n <= the number of digits in num     
    */    
    public static int getDigit(int num, int n)    
    {      
      int pos = getNumberOfDigits(num)-n+1;
      while(pos > 1){
        num/=10;
        pos--;
      }
      return num%10;
    }     
}
