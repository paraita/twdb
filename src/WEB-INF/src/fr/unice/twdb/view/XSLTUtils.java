package fr.unice.twdb.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTUtils {

	static TransformerFactory tf = TransformerFactory.newInstance();

	static public String xml2html(String xml, String xsltPath) {
		StreamSource xmlSource = new StreamSource(new ByteArrayInputStream( xml.getBytes() ));
		StreamSource xslt = new StreamSource(new File(xsltPath));

		try {
			Transformer transformation = tf.newTransformer(xslt);

			StringWriter sw = new StringWriter();
			StreamResult res = new StreamResult(sw);
			transformation.transform(xmlSource, res);

			return sw.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}
	
	/**
	 * Apply the xsl sheet if needed an send it to the client.
	 * @author bastien
	 * @param req
	 * @param res
	 * @param xsltPath Real path to the xslt sheet.
	 * @throws IOException
	 */	
	public static void generateResult(HttpServletRequest req, HttpServletResponse res, String xsltPath) throws IOException {
		PrintWriter out = res.getWriter();
		String xml = ((StringBuffer) req.getAttribute("result")).toString(); // we cast the xml result to a string
		
		if((Boolean) req.getAttribute("xml")) { // if user requested an xml result
			res.setContentType("text/xml");
			out.print(xml); // we just have to display it
		} else { // else we need to apply an xslt sheet to the result
			res.setContentType("text/html");
			String html = XSLTUtils.xml2html(xml, xsltPath);
			out.print(html); // and we display html result
		}
	}


}
