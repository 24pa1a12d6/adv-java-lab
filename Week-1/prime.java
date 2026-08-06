import java.util.*;
class prime
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
int num;
System.out.println("enter num");
num=sc.nextInt();
for(int i=2;i<=num;i++){
int count=0;
for(int j=1;j<=i;j++){
 if(i%j ==0)
{
count++;
}
}
if(count==2)
{
System.out.println(i+" ");
}
}
}
} 
