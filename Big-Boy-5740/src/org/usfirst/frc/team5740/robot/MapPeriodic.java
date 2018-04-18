import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.TimerTask;

import edu.wpi.first.wpilibj.Encoder;

class MapPeriodic extends TimerTask {
	String filename;
	static Encoder e1, e2;
	public MapPeriodic(Encoder enc1, Encoder enc2) {
		e1 = enc1;
		e2 = enc2;
	}
	static void Write(String line, String filename) throws IOException {
		File output = new File(filename);
		FileOutputStream outputStream = new FileOutputStream(output);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.write(line);
		writer.newLine();
		writer.close();
	}
    public void run() {
		String line = Integer.toString(e1.get()) + "\n" + Integer.toString(e2.get());
		try {
			Write(line, "test1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}