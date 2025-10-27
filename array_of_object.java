class demo
{
    String name;
    int marks;
}
class hello
{
    public static void main(String[] args)
    {
        demo s1=new demo();
        s1.name="Abhinay";
        s1.marks=99;   

        demo s2=new demo();
        s2.name="Abhi";
        s2.marks=59; 

        demo s3=new demo();
        s3.name="Akhil";
        s3.marks=99;       

        demo student[]=new demo[3];
        student[0]=s1;
        student[1]=s2;
        student[2]=s3;
        for(int i=0;i<student.length;i++)
        {
            System.out.println(student[i].name + ":" +  student[i].marks);

        }     
    }
}