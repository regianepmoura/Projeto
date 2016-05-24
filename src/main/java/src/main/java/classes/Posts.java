package src.main.java.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;


public class Posts {
	public String URL = "http://jsonplaceholder.typicode.com/posts";

	public boolean ValidaPosts(int ID) throws Exception {
		boolean retorno = false;

		HttpClient client = HttpClientBuilder.create().build();
		URL = URL + ID;
		HttpDelete request = new HttpDelete(URL);

		HttpResponse response = client.execute(request);

		if (response.getStatusLine().equals(200)) {
			retorno = true;
		} else
			throw new Exception("404. ID Inexistente");
		return retorno;
	}

	public void CriarNovoPost(String Titulo, String Body, String ID) throws IOException {

		HttpClientBuilder httpcb = HttpClientBuilder.create();
		CloseableHttpClient httpclient = httpcb.build();
		HttpPost req = new HttpPost(URL);

		ArrayList<NameValuePair> postParameters;
		postParameters = new ArrayList<NameValuePair>();
		postParameters.add(new BasicNameValuePair("title", Titulo));
		postParameters.add(new BasicNameValuePair("body", Body));
		postParameters.add(new BasicNameValuePair("userId", ID));
		req.setEntity(new UrlEncodedFormEntity(postParameters));
		CloseableHttpResponse resp = httpclient.execute(req);
		HttpEntity entity = resp.getEntity();
		InputStream in = entity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();

	}

	public void DetalhesPost(int ID) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		URL = URL + ID;
		HttpGet request = new HttpGet(URL);

		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			System.out.println(line);
		}

	}

	public void ListarTodos() throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);

		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			System.out.println(line);
		}
	}

	public void DeletarPosts(int ID) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();

		URL = URL + ID;
		HttpDelete request = new HttpDelete(URL);

		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			System.out.println(line);
		}
	}
}
