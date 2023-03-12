package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GitSearchUserDTO {
    Long id;

    String login;

    @JsonProperty("node_id")
    String nodeId;

    @JsonProperty("avatar_url")
    String avatar;

    @JsonProperty("gravatar_id")
    String gravatar;

    String url;

    @JsonProperty("html_url")
    String htmlUrl;

    @JsonProperty("followers_url")
    String followersUrl;


    @JsonProperty("subscriptions_url")
    String subscriptionsUrl;

}
