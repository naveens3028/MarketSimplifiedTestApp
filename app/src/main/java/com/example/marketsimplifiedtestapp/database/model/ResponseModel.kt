package com.example.marketsimplifiedtestapp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "MydataTable")
data class MyData (
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int? = 0,

    @ColumnInfo(name = "node_id")
    @SerializedName("node_id")
    var nodeId: String? = null,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String? = null,

    @ColumnInfo(name = "full_name")
    @SerializedName("full_name")
    var fullName: String? = null,

    @ColumnInfo(name = "private")
    @SerializedName("private")
    var private: Boolean? = null,

    @ColumnInfo(name = "owner")
    @SerializedName("owner")
    var owner: Owner? = null,

    @ColumnInfo(name = "html_url")
    @SerializedName("html_url")
    var htmlUrl: String? = null,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null,

    @ColumnInfo(name = "fork")
    @SerializedName("fork")
    var fork: Boolean? = null,

    @ColumnInfo(name = "url")
    @SerializedName("url")
    var url: String? = null,

    @ColumnInfo(name = "forks_url")
    @SerializedName("forks_url")
    var forksUrl: String? = null,

    @ColumnInfo(name = "keys_url")
    @SerializedName("keys_url")
    var keysUrl: String? = null,

    @ColumnInfo(name = "collaborators_url")
    @SerializedName("collaborators_url")
    var collaboratorsUrl: String? = null,

    @ColumnInfo(name = "teams_url")
    @SerializedName("teams_url")
    var teamsUrl: String? = null,

    @ColumnInfo(name = "hooks_url")
    @SerializedName("hooks_url")
    var hooksUrl: String? = null,

    @ColumnInfo(name = "issue_events_url")
    @SerializedName("issue_events_url")
    var issueEventsUrl: String? = null,

    @ColumnInfo(name = "events_url")
    @SerializedName("events_url")
    var eventsUrl: String? = null,

    @ColumnInfo(name = "assignees_url")
    @SerializedName("assignees_url")
    var assigneesUrl: String? = null,

    @ColumnInfo(name = "branches_url")
    @SerializedName("branches_url")
    var branchesUrl: String? = null,

    @ColumnInfo(name = "tags_url")
    @SerializedName("tags_url")
    var tagsUrl: String? = null,

    @ColumnInfo(name = "blobs_url")
    @SerializedName("blobs_url")
    var blobsUrl: String? = null,

    @ColumnInfo(name = "git_tags_url")
    @SerializedName("git_tags_url")
    var gitTagsUrl: String? = null,

    @ColumnInfo(name = "git_refs_url")
    @SerializedName("git_refs_url")
    var gitRefsUrl: String? = null,

    @ColumnInfo(name = "trees_url")
    @SerializedName("trees_url")
    var treesUrl: String? = null,

    @ColumnInfo(name = "statuses_url")
    @SerializedName("statuses_url")
    var statusesUrl: String? = null,

    @ColumnInfo(name = "languages_url")
    @SerializedName("languages_url")
    var languagesUrl: String? = null,

    @ColumnInfo(name = "stargazers_url")
    @SerializedName("stargazers_url")
    var stargazersUrl: String? = null,

    @ColumnInfo(name = "contributors_url")
    @SerializedName("contributors_url")
    var contributorsUrl: String? = null,

    @ColumnInfo(name = "subscribers_url")
    @SerializedName("subscribers_url")
    var subscribersUrl: String? = null,

    @ColumnInfo(name = "subscription_url")
    @SerializedName("subscription_url")
    var subscriptionUrl: String? = null,

    @ColumnInfo(name = "commits_url")
    @SerializedName("commits_url")
    var commitsUrl: String? = null,

    @ColumnInfo(name = "git_commits_url")
    @SerializedName("git_commits_url")
    var gitCommitsUrl: String? = null,

    @ColumnInfo(name = "comments_url")
    @SerializedName("comments_url")
    var commentsUrl: String? = null,

    @ColumnInfo(name = "issue_comment_url")
    @SerializedName("issue_comment_url")
    var issueCommentUrl: String? = null,

    @ColumnInfo(name = "contents_url")
    @SerializedName("contents_url")
    var contentsUrl: String? = null,

    @ColumnInfo(name = "compare_url")
    @SerializedName("compare_url")
    var compareUrl: String? = null,

    @ColumnInfo(name = "merges_url")
    @SerializedName("merges_url")
    var mergesUrl: String? = null,

    @ColumnInfo(name = "archive_url")
    @SerializedName("archive_url")
    var archiveUrl: String? = null,

    @ColumnInfo(name = "downloads_url")
    @SerializedName("downloads_url")
    var downloadsUrl: String? = null,

    @ColumnInfo(name = "issues_url")
    @SerializedName("issues_url")
    var issuesUrl: String? = null,

    @ColumnInfo(name = "pulls_url")
    @SerializedName("pulls_url")
    var pullsUrl: String? = null,

    @ColumnInfo(name = "milestones_url")
    @SerializedName("milestones_url")
    var milestonesUrl: String? = null,

    @ColumnInfo(name = "notifications_url")
    @SerializedName("notifications_url")
    var notificationsUrl: String? = null,

    @ColumnInfo(name = "labels_url")
    @SerializedName("labels_url")
    var labelsUrl: String? = null,

    @ColumnInfo(name = "releases_url")
    @SerializedName("releases_url")
    var releasesUrl: String? = null,

    @ColumnInfo(name = "deployments_url")
    @SerializedName("deployments_url")
    var deploymentsUrl: String? = null,

    @ColumnInfo(name = "comments")
    var comments: String? = null
)

data class Owner (
    @SerializedName("login")
    @Expose
    var login: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null,

    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null,

    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null,

    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null,

    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null,

    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null,

    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null,

    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null,

    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null,

    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null,

    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null,

    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null,

    @SerializedName("type")
    @Expose
    var type: String? = null,

    @SerializedName("site_admin")
    @Expose
    var siteAdmin: Boolean? = null
)

class OwnerConvertor {
    @TypeConverter
    fun listToJson(value: Owner?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Owner::class.java)
}