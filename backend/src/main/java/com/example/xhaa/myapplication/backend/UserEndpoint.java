/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Backend with Google Cloud Messaging" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/GcmEndpoints
*/

package com.example.xhaa.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.example.xhaa.myapplication.backend.OfyService.ofy;

/**
 * A registration endpoint class we are exposing for a device's GCM registration id on the backend
 * <p/>
 * For more information, see
 * https://developers.google.com/appengine/docs/java/endpoints/
 * <p/>
 * NOTE: This endpoint does not use any form of authorization or
 * authentication! If this app is deployed, anyone can access this endpoint! If
 * you'd like to add authentication, take a look at the documentation.
 */
@Api(name = "user",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.xhaa.example.com",
                ownerName = "backend.myapplication.xhaa.example.com",
                packagePath = ""))

public class UserEndpoint {

    private static final Logger log = Logger.getLogger(UserEndpoint.class.getName());

    @ApiMethod(name = "register")
    public void registerUser(@Named("userId") String userId,
                             @Named("username") String username,
                             @Named("email") String email,
                             @Named("tgllahir") String tgllahir,
                             @Named("role") String role,
                             @Named("pass") String pass
                             ) {
        if (findRecord(userId) != null) {
            log.info("Device " + userId + " already registered, skipping register");
            return;
        }
        UserRecord record = new UserRecord();
        record.setUserId(userId);
        record.setUsername(username);
        record.setEmail(email);
        record.setTgllahir(tgllahir);
        record.setPass(pass);
        record.setRole(role);
        ofy().save().entity(record).now();
    }
    /**
     * Return a collection of registered devices
     *
     * @param count The number of devices to list
     * @return a list of Google Cloud Messaging registration Ids
     */
    @ApiMethod(name = "listUsers")
    public CollectionResponse<RegistrationRecord> listUsers(@Named("count") int count) {
        List<RegistrationRecord> records = ofy().load().type(RegistrationRecord.class).limit(count).list();
        return CollectionResponse.<RegistrationRecord>builder().setItems(records).build();
    }
    // filter record via regId
    private RegistrationRecord findRecord(String regId) {
        return ofy().load().type(RegistrationRecord.class).filter("regId", regId).first().now();
    }

}
