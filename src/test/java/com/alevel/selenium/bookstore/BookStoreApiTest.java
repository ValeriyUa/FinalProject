package com.alevel.selenium.bookstore;

import com.alevel.selenium.restassured.model.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class BookStoreApiTest {

    private static final String BASE_URI = "https://demoqa.com/";
    private static final String ISBN = "ISBN";
    private static final String INVALID_ISBN = "0000000000000";

    private static class Endpoint {
        static final String AUTHORIZED = "Account/v1/Authorized";
        static final String GENERATE_TOKEN = "Account/v1/GenerateToken";
        static final String ALL_BOOKS = "BookStore/v1/Books";
        static final String BOOK = "BookStore/v1/Book";
    }

    private static class Message {
        static final String SUCCESS = "Success";
        static final String USER_AUTHORIZED_SUCCESSFULLY = "User authorized successfully.";
    }

    private LoginViewModel validLoginViewModel;
    private BookModel validBookModel;
    private MessageModel validMessageModel;


    private void configureModels() {

        Config config = ConfigFactory.parseResources("application.conf");

        validLoginViewModel = new LoginViewModel(
                config.getString("credentials.username"),
                config.getString("credentials.password")
        );

        validBookModel = new BookModel(
                "9781449325862",
                "Git Pocket Guide",
                "A Working Introduction",
                "Richard E. Silverman",
                "2020-06-04T08:48:39.000Z",
                "O'Reilly Media",
                234,
                "This pocket guide is the perfect on-the-job companion to Git,"
                        + " the distributed version control system. It provides a compact, "
                        + "readable introduction to Git for new users, "
                        + "as well as a reference to common commands and procedures for those of you with Git exp",
                "http://chimera.labs.oreilly.com/books/1230000000561/index.html"
        );

        validMessageModel = new MessageModel(1205, "ISBN supplied is not available in Books Collection!");
    }

    private void configureRestAssured() {

        BasicAuthScheme basicAuthScheme = new BasicAuthScheme();
        basicAuthScheme.setUserName(validLoginViewModel.getUserName());
        basicAuthScheme.setPassword(validLoginViewModel.getPassword());

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.ANY)
                .setAuth(basicAuthScheme)
                .log(LogDetail.ALL)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

    }

    @BeforeMethod
    public void configureTestCase() {
        configureModels();
        configureRestAssured();
    }

    @Test
    public void userLoginTest() {
        given().contentType(ContentType.JSON).body(validLoginViewModel)
                .when().post(Endpoint.AUTHORIZED)
                .then().assertThat().statusCode(200);
    }

    @Test
    public void generateTokenTest() {
        TokenViewModel tokenViewModel = given().contentType(ContentType.JSON).body(validLoginViewModel)
                .when().post(Endpoint.GENERATE_TOKEN)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(TokenViewModel.class);

        Assert.assertNotNull(tokenViewModel);
        Assert.assertNotNull(tokenViewModel.getToken());
        Assert.assertNotNull(tokenViewModel.getExpires());
        Assert.assertEquals(tokenViewModel.getStatus(), Message.SUCCESS);
        Assert.assertEquals(tokenViewModel.getResult(), Message.USER_AUTHORIZED_SUCCESSFULLY);
    }

    @Test
    public void getAllBooksTest() {
        AllBooksModel allBooksModel = given().contentType(ContentType.JSON)
                .when().get(Endpoint.ALL_BOOKS)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllBooksModel.class);

        Assert.assertNotNull(allBooksModel);
        Assert.assertNotNull(allBooksModel.getBooks());
        Assert.assertFalse(allBooksModel.getBooks().isEmpty());
    }

    @Test
    public void getBookTest() {
        BookModel bookModel = given().contentType(ContentType.JSON).queryParam(ISBN, validBookModel.getIsbn())
                .when().get(Endpoint.BOOK)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(BookModel.class);

        Assert.assertNotNull(bookModel);
        Assert.assertEquals(bookModel.getIsbn(), validBookModel.getIsbn());
        Assert.assertEquals(bookModel.getAuthor(), validBookModel.getAuthor());
        Assert.assertEquals(bookModel.getDescription(), validBookModel.getDescription());
        Assert.assertEquals(bookModel.getPages(), validBookModel.getPages());
        Assert.assertEquals(bookModel.getPublish_date(), validBookModel.getPublish_date());
        Assert.assertEquals(bookModel.getPublisher(), validBookModel.getPublisher());
        Assert.assertEquals(bookModel.getTitle(), validBookModel.getTitle());
        Assert.assertEquals(bookModel.getSubTitle(), validBookModel.getSubTitle());
        Assert.assertEquals(bookModel.getWebsite(), validBookModel.getWebsite());
    }

    @Test
    public void getBookInvalidIbsnTest() {
        MessageModel messageModel = given().contentType(ContentType.JSON).queryParam(ISBN, INVALID_ISBN)
                .when().get(Endpoint.BOOK)
                .then()
                .assertThat().statusCode(400)
                .extract().body().as(MessageModel.class);

        Assert.assertNotNull(messageModel);
        Assert.assertEquals(messageModel.getCode(), validMessageModel.getCode());
        Assert.assertEquals(messageModel.getMessage(), validMessageModel.getMessage());
    }

}
