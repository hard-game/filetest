import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Out {
    public static void main(String []args)throws Exception{
        String filePath="D:\\l\\spine images";
        File baseFile=new File(filePath);
        File[] files=baseFile.listFiles();
        String[] result=new String[files.length];
        OutputStream output=new FileOutputStream(new File("D:\\l\\result.txt"));
        for(int i=0;i<files.length;i++){
            String[] name=files[i].getName().split("\\.");
            String[] indexAndType=name[0].split("\\_");
            String index=indexAndType[0];
            String type=indexAndType[1];
            result[Integer.valueOf(index)-1]=type;
        }
        for (int i=0;i<result.length;i++){
            String out=String.valueOf(i+1)+"_"+result[i]+System.getProperty("line.separator");
            byte[] data=out.getBytes();
            output.write(data);
        }
    }
}
