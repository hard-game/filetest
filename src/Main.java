import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main{
    public static int num=-1;
    public static BufferedImage image;
    public static JFrame jFrame=new JFrame("test");
    public static JPanel jPanel=new JPanel(new FlowLayout());
    public static ImageIcon imageIcon=new ImageIcon();
    static {
        jFrame.setSize(500,1000);
    }
    public static void main(String[] args)  throws Exception {
        String filePath="D:\\l\\spine images";
        File baseFile=new File(filePath);
        File[] files=baseFile.listFiles();
        for (int i=0;i<files.length;i++){
//            files[i].renameTo(new File(filePath+"\\"+String.valueOf(i+1)+".jpg"));
//            String[] name=files[i].getName().split("\\.");
//            files[i].renameTo(new File(filePath+"\\"+name[0]+".bmp"));
        }

        changeImage(files);

        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton button=(JButton)e.getSource();
                if(button.getText().equals("-1")){
                    files[num].renameTo(new File(filePath+"\\"+String.valueOf(num+1)+"_-1"+".jpg"));
                }
                else if(button.getText().equals("0")){
                    files[num].renameTo(new File(filePath+"\\"+String.valueOf(num+1)+"_0"+".jpg"));
                }
                else {
                    files[num].renameTo(new File(filePath+"\\"+String.valueOf(num+1)+"_1"+".jpg"));
                }
                changeImage(files);
            }
        };

        JButton jButton1=new JButton("-1");
        jButton1.setSize(new Dimension(20,20));
        jButton1.addActionListener(listener);
        JButton jButton2=new JButton("0");
        jButton2.setSize(new Dimension(20,20));
        jButton2.addActionListener(listener);
        JButton jButton3=new JButton("1");
        jButton3.setSize(new Dimension(20,20));
        jButton3.addActionListener(listener);

        JLabel jLabel=new JLabel();
        jLabel.setIcon(imageIcon);

        jPanel.add(jLabel);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public static void changeImage(File[] files){
        try {
            num++;
            image= ImageIO.read(files[num]);
            int changeWidth=image.getWidth()/3;
            int changeHeigh=image.getHeight()/3;
            BufferedImage rimage=new BufferedImage(changeWidth,changeHeigh,BufferedImage.TYPE_INT_RGB);
            Graphics graphics=rimage.getGraphics();
            graphics.drawImage(image,0,0,changeWidth,changeHeigh,null);
            imageIcon .setImage(rimage);
            jPanel.updateUI();
        }
        catch (Exception ex){

        }
    }
}
