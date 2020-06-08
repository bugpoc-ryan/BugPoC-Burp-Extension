package burp;
import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;
import javax.swing.JMenuItem;
import java.awt.event.*;
import java.util.*;


public class BurpExtender implements IBurpExtender, IContextMenuFactory {
	
	private IExtensionHelpers helpers;
	
	@Override
	public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
		helpers = callbacks.getHelpers();
		callbacks.registerContextMenuFactory(this);
		callbacks.setExtensionName("BugPoC");
	}
	
	@Override
	public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
		final IHttpRequestResponse[] messages = invocation.getSelectedMessages();
		if (messages == null || messages.length != 1) return null;
		
		JMenuItem i1 = new JMenuItem("Send to BugPoC");
		i1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IHttpRequestResponse theMessage = messages[0];
				byte[] req = theMessage.getRequest();
				String baseUrl = "https://bugpoc.com/testers/http#";
				try{
					String req_str = new String(req);
					String encoded_req_str = URLEncoder.encode(req_str, "UTF-8");
					encoded_req_str = encoded_req_str.replace("+","%20");

					openURL(baseUrl+"pocData="+encoded_req_str);
				} catch (Exception er){
				}

			}
		});
		
		return Arrays.asList(i1);
	}
	
	private static void openURL(String url) {
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				URI uri = new URI(url);
				Desktop.getDesktop().browse(uri);
			}
		} catch (Exception e){
		}

	}
}


