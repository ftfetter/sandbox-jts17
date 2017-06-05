package cxf.rest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

public class TollResourceTest {

    HttpUriRequest request;
    HttpResponse response;

    @Test
    public void bicyclePrintTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/bicycle");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void bicyclePayTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/bicycle/payment/1");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void bicycleNoResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/bicycle/e");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void busPrintTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/bus");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void busPayTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/bus/payment/3");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void busNoResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/bus/j");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void carPrintTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/car");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void carPayTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/car/payment/1.15");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void carNoResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/car/k");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void motorcyclePrintTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/motorcycle");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void motorcyclePayTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/motorcycle/payment/0.5");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void motorcycleNoResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/motorcycle/h");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void truckPrintTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/truck/axis/2");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void truckPayTaxResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/truck/axis/0/payment/6");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void truckNoResponseTest() throws IOException {
        request = new HttpGet("http://localhost:8080/rest/toll/truck/p");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }
}
