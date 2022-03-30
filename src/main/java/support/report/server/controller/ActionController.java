package support.report.server.controller;

import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigCache;
import support.config.ConfigAllure;
import support.config.Configuration;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static support.context.Context.config;

@Log4j2
public class ActionController {

    private RequestSpecification request;
    private final ConfigAllure CONFIG_ALLURE;

    public ActionController() {
        CONFIG_ALLURE = ConfigCache.getOrCreate(ConfigAllure.class);
        request = RestAssured.given()
                .contentType(ContentType.MULTIPART)
                .accept("*/*");
    }

    private File getTargetFolder(){
        return new File("./target/allure-results");
    }

    public void sendResults(String projectId, String forceProjectCreation) {
        Response response = null;
        try{
            if (CONFIG_ALLURE.allureEnable()){
                final String URL = String.format("%s:%s/allure-docker-service/send-results?project_id=%s&force_project_creation=%s",
                        CONFIG_ALLURE.allureHost(),CONFIG_ALLURE.allurePort(),
                        URLEncoder.encode(CONFIG_ALLURE.allureProject()+"-"+config().getBrowser(), StandardCharsets.UTF_8.name()),
                        CONFIG_ALLURE.allureForceProjectCreation()).toLowerCase();
                log.info(URL);
                response = getFileMultPart(getTargetFolder()).post(URL);
                if (response.getStatusCode() != 200) {
                    log.error("Erro ao gerar report!");
                    log.error("Status Code: " +response.getStatusCode());
                    log.error("Error: "+response.getBody().prettyPrint());
                }else {
                    log.info(String.format("Results successfully sent for project_id '%s'",CONFIG_ALLURE.allureProject()));
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void sendResults() {
        Response response = null;
        try{
            if (CONFIG_ALLURE.allureEnable()){
                final String URL = String.format("%s:%s/allure-docker-service/send-results?project_id=%s&force_project_creation=%s",
                        CONFIG_ALLURE.allureHost(),CONFIG_ALLURE.allurePort(),
                        URLEncoder.encode(CONFIG_ALLURE.allureProject()+"-"+config().getBrowser(),StandardCharsets.UTF_8.name()),
                        CONFIG_ALLURE.allureForceProjectCreation()).toLowerCase();;
                log.info(URL);
                response = getFileMultPart(getTargetFolder()).post(URL);
                if (response.getStatusCode() != 200) {
                    log.error("Erro ao gerar report!");
                    log.error("Status Code: " +response.getStatusCode());
                    log.error("Error: "+response.getBody().prettyPrint());
                }else {
                    log.info(String.format("Results successfully sent for project_id '%s'",CONFIG_ALLURE.allureProject()));
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public RequestSpecification getFileMultPart(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getFileMultPart(fileEntry);
            } else {
                request.multiPart("files[]",new File(fileEntry.getAbsolutePath()));
            }
        }
        return request;
    }

}
