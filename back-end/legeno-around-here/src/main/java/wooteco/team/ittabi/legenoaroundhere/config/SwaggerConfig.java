package wooteco.team.ittabi.legenoaroundhere.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String CONTROLLER_PACKAGE_NAME = "wooteco.team.ittabi.legenoaroundhere.controller";
    private static final String DEFAULT_TITLE = "Legeno Around Here ";
    private static final String ALL_ANT_PATTERN_FORMAT = "/**%s**";

    private String groupName;

    @Bean
    public Docket areaApiDocket() {
        groupName = "areas";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/areas/"));
    }

    @Bean
    public Docket awardApiDocket() {
        groupName = "awards";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/awards/"));
    }

    @Bean
    public Docket commentApiDocket() {
        groupName = "comments";
        return getDocket(groupName,
            String.format(ALL_ANT_PATTERN_FORMAT, "/comments/"));
    }

    @Bean
    public Docket commentReportApiDocket() {
        groupName = "comment-reports";
        return getDocket(groupName,
            String.format(ALL_ANT_PATTERN_FORMAT, "/comment-reports/"));
    }

    @Bean
    public Docket imageApiDocket() {
        groupName = "images";
        return getDocket(groupName,
            String.format(ALL_ANT_PATTERN_FORMAT, "/images/"));
    }

    @Bean
    public Docket mailAuthApiDocket() {
        groupName = "mail-auth";
        return getDocket(groupName,
            String.format(ALL_ANT_PATTERN_FORMAT, "/mail-auth/"));
    }

    @Bean
    public Docket meApiDocket() {
        groupName = "me";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/me/"));
    }

    @Bean
    public Docket noticeApiDocket() {
        groupName = "notifications";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/notifications/"));
    }

    @Bean
    public Docket postApiDocket() {
        groupName = "posts";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/posts/"));
    }

    @Bean
    public Docket postReportApiDocket() {
        groupName = "post-reports";
        return getDocket(groupName,
            String.format(ALL_ANT_PATTERN_FORMAT, "/post-reports/"));
    }

    @Bean
    public Docket profileApiDocket() {
        groupName = "profile";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/profile/"));
    }

    @Bean
    public Docket rankingApiDocket() {
        groupName = "ranking";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/ranking/"));
    }

    @Bean
    public Docket sectorApiDocket() {
        groupName = "sectors";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/sectors/"));
    }

    @Bean
    public Docket userApiDocket() {
        groupName = "users";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/users/"));
    }

    @Bean
    public Docket userReportApiDocket() {
        groupName = "user-reports";
        return getDocket(groupName,
            String.format(ALL_ANT_PATTERN_FORMAT, "/user-reports/"));
    }

    @Bean
    public Docket zzangApiDocket() {
        groupName = "zzangs";
        return getDocket(groupName, String.format(ALL_ANT_PATTERN_FORMAT, "/zzangs/"));
    }

    @Bean
    public Docket userImageApiDocket() {
        groupName = "userImages";
        return getDocket(groupName, "/user-images/**");
    }

    @Bean
    public Docket joinApiDocket() {
        groupName = "join";
        return getDocket(groupName, "/join/**");
    }

    @Bean
    public Docket loginApiDocket() {
        groupName = "login";
        return getDocket(groupName, "/login/**");
    }

    private Docket getDocket(String groupName, String groupUrl) {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .groupName(groupName)
            .select()
            .apis(RequestHandlerSelectors
                .basePackage(CONTROLLER_PACKAGE_NAME))
            .paths(PathSelectors.ant(groupUrl))
            .build()
            .apiInfo(apiInfo(DEFAULT_TITLE + groupName, groupName));
    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
            title,
            "이따비의 팀 프로젝트 Legeno Around Here의 API Docs",
            version,
            "www.capzzang.co.kr",
            new Contact("Conetact Me", "www.capzzang.co.kr", "aegis1920@gmail.com"),
            "Ittabi Licenses",
            "www.capzzang.co.kr",
            new ArrayList<>()
        );
    }
}
