package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class jacobHelper {

	static final int wdDoNotSaveChanges = 0;// ����������ĸ��ġ�
	// private static final int xlTypePDF = 0;
	static final int wdFormatPDF = 17;// wordתPDF ��ʽ
	static final int ppSaveAsPDF = 32;// ppt תPDF ��ʽ

	public static void deleteFile(String src){
		File file= new File(src);
        if(file.isFile() && file.exists())
            file.delete();
	}
	
	public static void change(String inputFile, String pdfFile) {

		int splitIndex = inputFile.lastIndexOf(".");
		String suffix = inputFile.substring(splitIndex + 1);
		File file = new File(inputFile);
		if (!file.exists()) {
			System.out.println("�ļ������ڣ�");
			// return false;
		}
		if (suffix.equals("pdf")) {
			System.out.println("PDF not need to convert!");
			// return true;f
		}
		if (suffix.equals("doc") || suffix.equals("docx")
				|| suffix.equals("txt")) {
			// return
			word2pdf(inputFile, pdfFile);
		} else if (suffix.equals("ppt") || suffix.equals("pptx")) {
			// return
			ppt2pdf(inputFile, pdfFile);
		}
		// ȱ��pdf��ӡ�� execlת��PDF�����޷�ʹ��
		/*
		 * else if (suffix.equals("xls") || suffix.equals("xlsx")) { return
		 * excel2PDF(inputFile, pdfFile); }
		 */
		else {
			System.out.println("�ļ���ʽ��֧��ת��!");
			// return false;
		}
	}

	public static void word2pdf(String source, String target) {
		// boolean flag=true;
		System.out.println("����Word");
		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		try {
			app = new ActiveXComponent("Word.Application");
			app.setProperty("Visible", false);

			Dispatch docs = app.getProperty("Documents").toDispatch();
			System.out.println("���ĵ�" + source);
			Dispatch doc = Dispatch.call(docs,//
					"Open", //
					source,// FileName
					false,// ConfirmConversions
					true // ReadOnly
					).toDispatch();

			System.out.println("ת���ĵ���PDF " + target);
			File tofile = new File(target);
			if (tofile.exists()) {
				tofile.delete();
			}
			Dispatch.call(doc,//
					"SaveAs", //
					target, // FileName
					wdFormatPDF);

			Dispatch.call(doc, "Close", false);
			long end = System.currentTimeMillis();
			System.out.println("ת�����..��ʱ��" + (end - start) + "ms.");
			deleteFile(source);
		} catch (Exception e) {
			System.out.println("========Error:�ĵ�ת��ʧ�ܣ�" + e.getMessage());
		} finally {
			if (app != null)
				app.invoke("Quit", wdDoNotSaveChanges);
		}
	}

	public static void ppt2pdf(String source, String target) {
		System.out.println("����PPT");
		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		try {
			app = new ActiveXComponent("Powerpoint.Application");
			Dispatch presentations = app.getProperty("Presentations")
					.toDispatch();
			System.out.println("���ĵ�" + source);
			Dispatch presentation = Dispatch.call(presentations,//
					"Open", source,// FileName
					true,// ReadOnly
					true,// Untitled ָ���ļ��Ƿ��б��⡣
					false // WithWindow ָ���ļ��Ƿ�ɼ���
					).toDispatch();

			System.out.println("ת���ĵ���PDF " + target);
			File tofile = new File(target);
			if (tofile.exists()) {
				tofile.delete();
			}
			Dispatch.call(presentation,//
					"SaveAs", //
					target, // FileName
					ppSaveAsPDF);

			Dispatch.call(presentation, "Close");
			long end = System.currentTimeMillis();
			System.out.println("ת�����..��ʱ��" + (end - start) + "ms.");
			deleteFile(source);
		} catch (Exception e) {
			System.out.println("========Error:�ĵ�ת��ʧ�ܣ�" + e.getMessage());
		} finally {
			if (app != null)
				app.invoke("Quit");
		}
	}

	public void excel2pdf(String source, String target) {
		System.out.println("����Excel");
		long start = System.currentTimeMillis();
		ActiveXComponent app = new ActiveXComponent("Excel.Application"); // ����excel(Excel.Application)
		try {
			app.setProperty("Visible", false);
			Dispatch workbooks = app.getProperty("Workbooks").toDispatch();
			System.out.println("���ĵ�" + source);
			Dispatch workbook = Dispatch.invoke(
					workbooks,
					"Open",
					Dispatch.Method,
					new Object[] { source, new Variant(false),
							new Variant(false) }, new int[3]).toDispatch();
			Dispatch.invoke(workbook, "SaveAs", Dispatch.Method, new Object[] {
					target, new Variant(57), new Variant(false),
					new Variant(57), new Variant(57), new Variant(false),
					new Variant(true), new Variant(57), new Variant(true),
					new Variant(true), new Variant(true) }, new int[1]);
			Variant f = new Variant(false);
			System.out.println("ת���ĵ���PDF " + target);
			Dispatch.call(workbook, "Close", f);
			long end = System.currentTimeMillis();
			System.out.println("ת�����..��ʱ��" + (end - start) + "ms.");
			deleteFile(source);
		} catch (Exception e) {
			System.out.println("========Error:�ĵ�ת��ʧ�ܣ�" + e.getMessage());
		} finally {
			if (app != null) {
				app.invoke("Quit", new Variant[] {});
			}
		}
	}

	// �����execlת������
	/*
	 * public boolean excel2PDF(String inputFile,String pdfFile){ try{
	 * ActiveXComponent app = new ActiveXComponent("Excel.Application");
	 * app.setProperty("Visible", false); Dispatch excels =
	 * app.getProperty("Workbooks").toDispatch(); Dispatch excel =
	 * Dispatch.call(excels, "Open", inputFile, false, true ).toDispatch();
	 * Dispatch.call(excel, "ExportAsFixedFormat", xlTypePDF, pdfFile );
	 * Dispatch.call(excel, "Close",false); app.invoke("Quit"); return true;
	 * }catch(Exception e){ return false; }
	 * 
	 * }
	 */

	// ����
	/*
	 * public static void main(String[] args) { String source1 =
	 * "D:\\test.docx"; String source2 = "D:\\a.xlsx"; String source3 =
	 * "D:\\aa.pptx"; String target1 = "D:\\test1.pdf"; String target2 =
	 * "D:\\test2.pdf"; String target3 = "D:\\test3.pdf";
	 * 
	 * 
	 * jacobHelper pdf=new jacobHelper();
	 * 
	 * pdf.word2pdf(source1, target1); pdf.excel2pdf(source2, target2);
	 * pdf.ppt2pdf(source3, target3);
	 * 
	 * 
	 * }
	 */

	public static void homework(String wordpath, String pdfpath, String brief) {
		try {
			/*д��word
			FileOutputStream fo = new FileOutputStream(wordpath);
			OutputStreamWriter osw = new OutputStreamWriter(fo);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(brief);
			bw.flush();*/
			
			//д��txt
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(wordpath),true));
		    writer.write(brief);		     
		    writer.close();
			word2pdf(wordpath,pdfpath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
