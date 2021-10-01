# Sudo Twitter Backend Project API
### Credit to Shensheng Chen, Jason Chang
***
This project delivers a Twitter-like product API User Friendly List

## User

With proper authorization your application can read and update a user's account and profile settings. Not all settings are exposed via the API.

* >user/register 

|Parameters|Default|Description|
|----|----|----|
|Email_register|XX@gmail.com|The Email Address that can be used to register|
|password_register|123456|The password that can be used to register|

* >user/login

|Parameters|Default|Description|
|----|----|----|
|Email_login|XX@gmail.com|The Email Address that can be used to login|
|password_login|123456|The password that can be used to login|

* >user/peopleyoumayknow

|Parameters|Default|Description|
|----|----|----|
|uid|000000000|The uid that can be used to find people you may know|

* >user/thirdpartyauth

|Parameters|Default|Description| 
|----|----|----|
|External|GoogleValidations1Firstname=ShenshengLastname=Chen|Some external validation results with key word Firstname and Lastname|

* >user/follows

|Parameters|Default|Description|
|----|----|----|
|uid|000000000|The uid that can be used to find uid follows who|

* >user/followers

|Parameters|Default|Description|
|----|----|----|
|uid|000000000|The uid that can be used to find who follows that specific uid|

## Twitter
The following API endpoints can be used to programmatically create, retrieve and delete Tweets, Retweets and Likes:

* > twitter/generatetid

|Parameters|Default|Description|
|----|----|----|
|uid|000000000|The uid that can be used to generate a unique original twitter post id|
This function will return a tid which client can use it with the content to submit, what's more, unathorized user (user in blacklist will get a warning tid )
* > twitter/post
  
|Parameters|Default|Description|
|----|----|----|
|content|yoyo|The content of this post|
|tid_refer|11111|The twitter id that assigned to this post (as original) or as referral|
|timeline|Jan 11|The timeline of this post|
this post function will return a tid which future post can use it as referral


* > twitter/retweet
  
|Parameters|Default|Description|
|----|----|----|
|tid|11111|The twitter id that assigned to this post (as original) or as referral|
|timeline|Jan 11|The timeline of this post|
this post function will return a tid (even as retweet) which future post can use it as referral


* > twitter/like

|Parameters|Default|Description|
|----|----|----|
|tid|11111|The twitter id that assigned to this post (as original) or as referral|
|status|True|The status of the like|
this post function will return a tid (even as like) which future post can use it as referral

* > twitter/dislike

|Parameters|Default|Description|
|----|----|----|
|tid|11111|The twitter id that assigned to this post (as original) or as referral|
|status|True|The status of the dislike|
this post function will return a tid (even as dislike) which future post can use it as referral



* > twitter/comment

|Parameters|Default|Description|
|----|----|----|
|content|awww|The content of this post|
|tid_refer|11111|The twitter id that assigned to this post (as original) or as referral|
|timeline|Jan 11|The timeline of this post|
this post function will return a tid (as a comment) which future post can use it as referral

## Trending

* > trending/currenthotfeed

This post will return the currenthotfeed

* > trending/personalize_recommend_feed

|Parameters|Default|Description|
|----|----|----|
|uid|11111|The user id that requires for personalized feed|

* > trending/related_feed
  
|Parameters|Default|Description|
|----|----|----|
|tid|11111|the thread id that can be used for related posts|