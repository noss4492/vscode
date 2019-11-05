package day18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx10 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("z:\\dos.txt");
		
		DataOutputStream dos = new DataOutputStream(fos);
		// @. @
		// @ .@ ∂—∑Á∂—∂—∑Á ∂—∑Á∂—∂—∑Á ∂—∑Á∂—∂—∑Á ∂—∑Á ∂—∂— ∂—∑Á ∂—∂—∑Á ∂—∑Á∂—∂—∑Á ∂—∑Á∑Á ∂—∑Á∂—∂—∑Á
		// @. @
		dos.writeUTF("±Êµø»´");
		dos.writeInt(20);
		dos.writeFloat(187.0f);
		dos.writeFloat(60.0f);
		dos.writeBoolean(true);
		// «¡∏ÆπÃ∆º∫Í≈∏¿‘¿∫ πŸ¿Ã≥ ∏Æ«¸≈¬∑Œ ¿˙¿Âµ 

		FileInputStream fis = new FileInputStream("z:\\dos.txt");
		DataInputStream dis = new DataInputStream(fis);
	
		String name = dis.readUTF();
		int age = dis.readInt();
		float height = dis.readFloat();
		float weight = dis.readFloat();
		boolean gender = dis.readBoolean();
		
		System.out.printf("%5s %2d %4.1f %4.1f %1s\n", name, age, height, weight, (gender)?"≥≤":"ø©");
		
		
		
		
	}
}
