package com.sabir.rest.webservices.restfull_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonControleer {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {

        return new PersonV1("Bob charlie");

    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {

        return new PersonV2(new Name("Bob","charlie"));

    }

    @GetMapping(path = "/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersoninParamV1() {

        return new PersonV1("Bob charlie");

    }


    @GetMapping(path= "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersoninParamPersonV2() {

        return new PersonV2(new Name("Bob","charlie"));

    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersoninHeader() {

        return new PersonV1("Bob charlie");

    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersoninHeader() {

        return new PersonV2(new Name("Bob","charlie"));

    }

    @GetMapping(path = "/person/header",produces =  "application/app-v1+json")
    public PersonV1 getFirstVersionOfPersoninAccept() {

        return new PersonV1("Bob charlie");

    }
    @GetMapping(path = "/person/header",produces =  "application/app-v2+json")
    public PersonV2 getSecondVersionOfPersoninAccept() {

        return new PersonV2(new Name("Bob","charlie"));

    }

}
