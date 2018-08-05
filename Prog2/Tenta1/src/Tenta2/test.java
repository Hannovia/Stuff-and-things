package Tenta2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class test extends JPanel{
 private ImageIcon bild = new ImageIcon("plan6.png");
 private int x, y;
 private boolean visas = false;
 protected void paintComponent(Graphics g){
super.paintComponent(g);
g.drawImage(bild.getImage(), 0,0, this);
if (visas){
 g.setColor(Color.BLACK);
 g.fillOval(x-10,y-10,15,15);
}
 }
 public void setXY(int x, int y){
this.x = x;
this.y = y;
 }
 public void setVisas(boolean b){
visas = b;
repaint();
 }
}
class Karta extends JFrame{
 String[] namn = {"Andrea","Bea","Birger","Björn","Dan","David","Elin",
"Gustaf","Henrik","Ilja","Jozef","Lena","Leon","Louise",
"Maria","Martin","Matts","Patrik","Paul","Stefan",
"Stewart","Tessi"};
 test kp = new test();
 JList<String> folkList = new JList<>(namn);
 Map<String, Point> where = new HashMap<String,Point>();
 Karta(){
JPanel höger = new JPanel();
add(höger, BorderLayout.WEST);
folkList.setVisibleRowCount(20);
höger.add(new JScrollPane(folkList));
add(kp, BorderLayout.CENTER);
JPanel knappPanel = new JPanel();
add(knappPanel, BorderLayout.SOUTH);
JButton visaKnapp = new JButton("Visa");
knappPanel.add(visaKnapp);
visaKnapp.addActionListener(new VisaLyss());
JButton angeKnapp = new JButton("Ange");
knappPanel.add(angeKnapp);
angeKnapp.addActionListener(new AngeLyss());
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(630, 450);
setVisible(true);
 }

 class AngeLyss implements ActionListener{
 public void actionPerformed(ActionEvent ave){
 kp.setVisas(false);
 kp.addMouseListener(new MusLyss());
 }
 }
 class MusLyss extends MouseAdapter{
 public void mouseClicked(MouseEvent mev){
 if (folkList.isSelectionEmpty()){
 JOptionPane.showMessageDialog(Karta.this, "Ingen vald!");
 return;
}
String vem = (String)folkList.getSelectedValue();
int x = mev.getX();
int y = mev.getY();
where.put(vem, new Point(x,y));
kp.setXY(x, y);
kp.setVisas(true);
kp.removeMouseListener(this);
 }
 }
 class VisaLyss implements ActionListener{
 public void actionPerformed(ActionEvent ave){
 if (folkList.isSelectionEmpty()){
 JOptionPane.showMessageDialog(Karta.this, "Ingen vald!");
 return;
}
String vem = (String)folkList.getSelectedValue();
Point p = where.get(vem);
if (p == null){
 JOptionPane.showMessageDialog(Karta.this, "Ingen plats!");
 return;
}
kp.setXY(p.x, p.y);
kp.setVisas(true);
 }
 }
 public static void main(String[] args){
new Karta();
 }
}