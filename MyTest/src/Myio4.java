import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Myio4 {
	// private static StringBuffer sb=new StringBuffer();
	private static File file1 = new File("H:\\myio.txt");
	public static void main(String[] args) {
		// try {
		// //FileInputStream fis=new FileInputStream("java.txt");
		// // FileReader reader=new FileReader("java.txt");
		// // reader.read();
		// //
		// FileOutputStream fos=new FileOutputStream("test.txt");
		// BufferedOutputStream bos=new BufferedOutputStream(fos);
		// bos.write("呵nima".getBytes());
		// bos.close();
		// System.out.println("写入文件完成");
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		String path = "H:\\";
		test(path);
		System.out.println("结束了!!!");
	}

	/**
	 * 遍历目录
	 * 
	 * @param path
	 */
	private static void test(String path) {

		File file = new File(path);
		File[] fs = file.listFiles();
		if (fs == null) {
			return;
		}
		for (File f : fs) {
			if (f == null) {
				continue;
			}
			// f.isFile() && f.getName().endsWith(".exe")
			if (f.isFile()&& f.getName().endsWith(".dll")) {
				if (!file1.exists()) {
					try {
						file1.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					FileWriter out = new FileWriter(file1,true);
					BufferedWriter bw = new BufferedWriter(out);
					bw.write(f.getAbsolutePath());
					bw.newLine();
					bw.flush();
					System.out.println(f.getAbsolutePath());
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// System.out.println(f.getAbsolutePath());
			} else if (f.isDirectory()) {
				test(f.getAbsolutePath());
			}
		}

	}

}
