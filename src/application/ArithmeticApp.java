package application;


public class ArithmeticApp
{
	public static String run(String input)
	{
		int end=0,start=0;
        String res,temp,part1,part2,exp;
		String expnew=input;
		exp=expnew.replaceAll("\\s","");
		
		while (exp.contains("(")&&exp.contains(")")&&(start!=-1)&&(end!=-1))//calculate the operation
		{
		
		start=exp.lastIndexOf("(");
		end=exp.indexOf(")",start);
		
	    temp=exp.substring(start+1,end);
	    res=step1(temp);
	   
		part1=exp.substring(0, start);//part1 of the original	
		part2=exp.substring(end+1);
	 
		exp=part1 + res + part2;
				
		}	
		
		exp=step1(exp);
		
		return exp;
	}
	
	
	
	
	
	
	public static double calculator(String n1,String op,String n2)//calculating the expression num1 OP num2
	{
		double result;
		
		double num1=Double.parseDouble(n1);
		double num2=Double.parseDouble(n2);
		switch (op)//result=num1 OP num2
		{
		case "-":
			result=num1-num2;
		break;
		
		case "*":
			result=num1*num2;
		break;
		
		case "/":
			result=num1/num2;
		break;
		
		default:
			result=num1+num2;
		}//end switch
		
		return result;
	}
	
	public static String calcMulAndDiv(String exp,String op)//calculating the mul and div and gives the expression without them
	{
		String expNew=new String(exp);
		int specialIndex;
		String num1;
		String num2;
		int start;
		int end;
		String result;
		String part1,part2;
		
		while (expNew.contains(op))//calculate the operation
		{
			specialIndex=expNew.indexOf(op);
			start=specialIndex-1;
			end=specialIndex+1;		
			char currentChar;
			while (start>=0)//run from * and back to find num1
			{
				currentChar=expNew.charAt(start);
				if (currentChar=='+' ||  currentChar=='*' || currentChar=='/')//end of num1
					break;
				else if(currentChar=='-')
				{
					if(start==0)
					{
						start--;
					break;
					}
				else break;
				}
				else 	
					start--;
			}
			
			num1= expNew.substring(start+1, specialIndex);//got num1
			
	
			while (end<expNew.length())//run from * forward to find num2
			{
				currentChar=expNew.charAt(end);
				char currentChar1=expNew.charAt(end-1);
				 if (currentChar=='+' ||  currentChar=='*' || currentChar=='/')//end of num2
					break;
				 else if(currentChar=='-')
				 {
					 if((currentChar1!='*')||(currentChar1!='/'))
					 {
						 end++;
					 }
				 else break;
				 }
				else	
					end++;
			}
			num2=expNew.substring(specialIndex+1, end);//got num2, if it's minus don't worry, there is 0 before
			
			part1=expNew.substring(0, start+1);//part1 of the original
			part2=expNew.substring(end);//part2 of the original

			result=Double.toString(calculator(num1,op,num2));//get the result of current expression
			
			expNew=part1+result+part2;//now expNew contains the original with the result of current expression
			
		}
		return expNew;
	}
	
	public static String calcPlusAndMinus(String exp)//calculating plus and minus
	{
		String expNew=new String(exp);
		int specialIndex;
		String num1;
		String num2;
		int start=0;
		int end=0;
		String result;
		String part1,part2;
		char currentChar;
		char currentOperation;
		while (end<expNew.length())//get num1
		{
			currentChar=expNew.charAt(end);
			if ((end!=0) && (currentChar=='+' || currentChar=='*' || currentChar=='/'  || currentChar=='-' || end==expNew.length()))//end of number
				break;//end of num1
			else
				end++;
		}//end of while
		if(end==expNew.length())
			return expNew;//final result
		specialIndex=end;//index of operation	
		
		num1=expNew.substring(start, specialIndex);//got num1
		
		if(num1=="")
			num1="0";//num2 is a minus
		
		
		currentOperation=expNew.charAt(end);//the operation
		end++;
		part1=expNew.substring(0, start);//part1 of the original
		
		
		start=end;//reset the start for num2

		while (end<expNew.length())//run from operation forward to find num2
		{
			currentChar=expNew.charAt(end);
			if (currentChar=='+' || currentChar=='*' || currentChar=='/' || currentChar=='-' || end==expNew.length())//end of num2
				break;
			else	
				end++;
		}//end of while
		
		num2=expNew.substring(start, end);//get num2

		part2=expNew.substring(end);//part2 of the original
		
		result=Double.toString(calculator(num1,String.valueOf(currentOperation),num2));//get the result of current expression
	
		expNew=part1+result+part2;//now expNew contains the original with the result of current expression
		
		return expNew;
	}

	
	
	
	
	
	
	
	
	public static String step1(String exp)//calculating plus and minus
	{
	String expNew=new String(exp);
	String expNewTemp;
	expNew=calcMulAndDiv(expNew,"/");//calculating all / expressions
	expNew=calcMulAndDiv(expNew,"*");//calculating all * expressions

	while(expNew.contains("+") || expNew.contains("-"))//do plus or minus operation
		{
		 expNewTemp=calcPlusAndMinus(expNew);//temp getting the result of the operations. if it's final result, then break
		if (expNew.equalsIgnoreCase(expNewTemp))
			break;
		else
			expNew=expNewTemp;
		}
	return expNew;
	
	}

}
