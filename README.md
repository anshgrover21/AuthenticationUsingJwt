# Assignment
This project is an assignment for PAF

Here I am doing all the mentioned task in assignment and workin of the above is mentioned below
Docker configuration are done in folder name PAF

## Commands to execute
1. Start Docker Engine, and import the folder PAF from the repo
2. open the terminal from folder, path should be.. "../PAF"
3. In the terminal execute the command "docker-compose up -d" , This command will run the program in local server
4. Port For spring: localhost:8080
5. Port using for Database: localhost:3360
6. SQL password would be : "rootroot"
7. SQL username: "root"
8. DatabaseName: "userCredentials"


## API's

All the api's mentioned below are shared in the above repo as a Postman collection in a file name **"Auth_Apis.postman_collection"**, In JSON format.

1. SignIn for User
2. SignIn for Admin
3. LogIn
4. RefreshToken
5. RevokeToken
6. User

## Functioning

### Authorities
1. USER: those who can access the refresh token endpoint. These are actual users.
2. ADMIN: Those who work in the backend and perform administration tasks, eg revoking token from backend.

### Functionality

1. SignIn and LogIn end points are permitted to all and are not authenticated. User can sign In from SignIn for User endpoint and Admin from signing For Admin. Just Have to provide a username and password passing from key.
    key1 : 'UserName'
    key2 : 'password'

   For logIn the format is same, It Will return a JWT token in body which will be user to access other endpoints. TTL For JWT token is set for 30 mins...

2. **User** : This is addressed to USER only and the user can access this endpoint only by adding a valid JWT token by setting the AUTH TYPE Bearer Token and entering the token provided while LOGIn in the token field or By entry correct credentials in AUTH TYPE Basic AUTH
  (This is for testing JWT TOKEN is working)

3. **Refresh Token** : This is autherised and authenticated by USER only , User can access this again by either using given token or by entering correct credentials. This will return a fresh token which will be further used with fresh TT;

4. **Revoke TOken** : This is autherised and authenticated by ADMIN only , if user try to access this will get 403 error, Create admin first and then use admin credentials or created jwt to access this end point . Credentials are need to be added from BASIC AUTH.
                  This field revoke the provided token. This requires valid token which need to be revoke and credentials from Basic Auth.

   key in refresh and revoke token is 'token'
