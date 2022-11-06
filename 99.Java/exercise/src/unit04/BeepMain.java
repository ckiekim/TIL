package unit04;

import java.awt.Toolkit;

public class BeepMain {

    public static void main(String[] args) {
        //how1
//        Runnable beepTask = new BeepTask();
//        Thread thread = new Thread(beepTask);
        
        //how2
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Toolkit toolkit = Toolkit.getDefaultToolkit();  
//                for(int i=0; i<5; i++) {        
//                    toolkit.beep();
//                    try { Thread.sleep(500); } catch(Exception e) {}
//                }
//            }
//        });
        
        //how3
//        Thread thread = new Thread(() -> {
//            Toolkit toolkit = Toolkit.getDefaultToolkit();  
//            for(int i=0; i<5; i++) {        
//                toolkit.beep();
//                try { Thread.sleep(500); } catch(Exception e) {}
//            }
//        });
        Thread thread = new BeepThread();
        thread.start();
        
        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }

}
