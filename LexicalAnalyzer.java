import java.util.*;

class LexicalAnalyzer {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);    
    System.out.println("Insert string: ");
    String input = userInput.nextLine();

    parseString(input);    
  }

  public static void parseString(String str) {
    String arrstr = str;
    if(str.charAt(str.length()-1) == ';'){
      arrstr = str.substring(0,str.length()-1);
    }
    
    String[] arr = arrstr.split(" ");
    int a = 0;
    int arrlen = arr.length;
    

    int addop = 0, subop = 0, multiop = 0, diviop = 0, modop = 0, groupop = 0, assignop = 0, equalsop = 0, lessop = 0, lesseop=0, greatop=0, greateop = 0, logandop = 0, logorop = 0, varid = 0, intlit = 0, fpl = 0;

    while(a != arrlen) {
      String subStr = arr[a];
      if(addOperator(subStr)){
        addop++;
        a++;
        continue;
      }
      if(subOperator(subStr)){
        subop++;
        a++;
        continue;
      }
      if(multiOperator(subStr)){
        multiop++;
        a++;
        continue;
      }
      if(diviOperator(subStr)){
        diviop++;
        a++;
        continue;
      }
      if(modOperator(subStr)){
        modop++;
        a++;
        continue;
      }
      if(groupOperator(subStr)){
        groupop++;
        a++;
        continue;
      }
      if(assignOperator(subStr)){
        assignop++;
        a++;
        continue;
      }
      if(equalsOperator(subStr)){
        equalsop++;
        a++;
        continue;
      }
      if(lessOperator(subStr)){
        lessop++;
        a++;
        continue;
      }
      if(lesseOperator(subStr)){
        lesseop++;
        a++;
        continue;
      }
      if(greatOperator(subStr)){
        greatop++;
        a++;
        continue;
      }
      if(greateOperator(subStr)){
        greateop++;
        a++;
        continue;
      }
      if(logAndOperator(subStr)){
        logandop++;
        a++;
        continue;
      }
      if(logOrOperator(subStr)){
        logorop++;
        a++;
        continue;
      }
      if(varIdentifier(subStr)){
        varid++;
        a++;
        continue;
      }
      if(intLiteral(subStr)){
        intlit++;
        a++;
        continue;
      }
      if(floatpLiteral(subStr)){
        fpl++;
        a++;
        continue;
      }

      a++;
    }

    System.out.println("\nThere are a total of: " + "\nAddition Operators: "+addop+"\nSubtraction Operators: " +subop+"\nMultiplication Operators: "+multiop+"\nDivision Operators: "+diviop+"\nModulo Operators: "+modop+"\nGrouping Operators: "+groupop+"\nAssignment Operators: "+assignop+"\nEquals Operator: "+equalsop+"\nLess Than Operator: "+lessop+"\nLess than or equal to Operators: "+lesseop+"\nGreater than Operators: "+greatop+"\nGreater than or equal to Operators: "+greateop+"\nLogical AND Operators: "+logandop+"\nLogical OR Operators: "+logorop+"\nVariable Identifiers: "+varid+"\nInteger Literals: "+intlit+"\nFloating Point Literals: "+fpl);

    
  }

  public static boolean addOperator(String str) {
    if(str.equals("+")) 
      return true;
    else
      return false;
  }

  public static boolean subOperator(String str) {
    if(str.equals("-")) 
      return true;
    else
      return false;
  }
  public static boolean multiOperator(String str) {
    if(str.equals("*")) 
      return true;
    else
      return false;
  }
  public static boolean diviOperator(String str) {
    if(str.equals("/")) 
      return true;
    else
      return false;
  }
  public static boolean modOperator(String str) {
    if(str.equals("%")) 
      return true;
    else
      return false;
  }
  public static boolean groupOperator(String str) {
    if(str.equals("(")||str.equals(")")||str.equals("[")||str.equals("]")||str.equals("{")||str.equals("}")) 
      return true;
    else
      return false;
  }
  public static boolean assignOperator(String str) {
    if(str.equals("+=")||str.equals("-=")||str.equals("/=")||str.equals("*=")) 
      return true;
    else
      return false;
  }
  public static boolean equalsOperator(String str) {
    if(str.equals("=")) 
      return true;
    else
      return false;
  }
  public static boolean lessOperator(String str) {
    if(str.equals("<")) 
      return true;
    else
      return false;
  }
  public static boolean lesseOperator(String str) {
    if(str.equals("<=")) 
      return true;
    else
      return false;
  }
  public static boolean greatOperator(String str) {
    if(str.equals(">")) 
      return true;
    else
      return false;
  }
  public static boolean greateOperator(String str) {
    if(str.equals(">=")) 
      return true;
    else
      return false;
  }
  public static boolean logAndOperator(String str) {
    if(str.equals("&&")) 
      return true;
    else
      return false;
  }
  public static boolean logOrOperator(String str) {
    if(str.equals("||")) 
      return true;
    else
      return false;
  }
  public static boolean varIdentifier(String str) {
if(str.equals("int")||str.equals("double")||str.equals("float")||str.equals("if")||str.equals("else")||str.equals("while")||str.equals("do")||str.equals("break")||str.equals("continue")) 
      return true;
    else
      return false;
  }
  public static boolean intLiteral(String str) {
    if(str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||str.equals("5")|str.equals("6")||str.equals("7")||str.equals("8")||str.equals("9")||str.equals("0")) 
      return true;
    else
      return false;
  }
  public static boolean floatpLiteral(String str) {
    if(str.contains(".")) 
      return true;
    else
      return false;
  }
  
  

  
}