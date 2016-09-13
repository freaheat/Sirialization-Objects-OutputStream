
package sirialization.objects.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main {
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    
    public static void main(String[] args) {
        //profiles = (ArrayList<Profile>) dserData("profiles");
        System.out.println(profiles.size());
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, "Р’РІРµРґРёС‚Рµ РІР°С€Рµ РёРјСЏ: "));
        profile.setSurname(JOptionPane.showInputDialog(null, "Р’РІРєР»РёС‚Рµ РІР°С€Сѓ С„Р°РјРёР»РёСЋ: "));
        profiles.add(profile);
        for(Profile p: profiles){
            System.out.println( p.getName() + " " + p.getSurname());
        }
        System.out.println(profiles.size());
        serData("profiles", profiles);
    }

    private static void serData(String file_name, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Р¤Р°Р№Р» РЅРµ РЅР°Р№РґРµРЅ");
            System.exit(1);
        }
          catch (IOException ex) {
            System.out.println("РћС€РёР±РєР° РІРІРѕРґР°/РІС‹РІРѕРґР°");
            System.exit(2);
        }        
    }

    private static Object dserData(String file_name) {
        Object retObject = null;
         try {
            FileInputStream fileIn = new FileInputStream(file_name + ".ser");
            ObjectInputStream input = new ObjectInputStream(fileIn);
            retObject = input.readObject();
            fileIn.close();
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Р¤Р°Р№Р» РЅРµ РЅР°Р№РґРµРЅ");
            System.exit(1);
        }
          catch (IOException ex) {
            System.out.println("РћС€РёР±РєР° РІРІРѕРґР°/РІС‹РІРѕРґР°");
            System.exit(2);
        }
          catch (ClassNotFoundException ex) {
              System.out.println("Class not found");
              System.exit(3);
          }
         return retObject;
    }
    
}
