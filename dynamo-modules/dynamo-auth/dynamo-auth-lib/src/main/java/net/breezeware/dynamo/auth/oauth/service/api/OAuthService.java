package net.breezeware.dynamo.auth.oauth.service.api;

import java.util.List;
import java.util.Optional;

import com.querydsl.core.types.Predicate;

import net.breezeware.dynamo.auth.oauth.dto.OAuthConnectionProperties;
import net.breezeware.dynamo.auth.oauth.entity.UserOAuthToken;

public interface OAuthService {

    /**
     * Create a new token or update an existing token with the one provided.
     * @param userOAuthToken the token that will replace the existing token with
     *                       similar User and Application.
     * @return Token that was persisted in the database
     */
    UserOAuthToken createOrUpdateToken(UserOAuthToken userOAuthToken);

    /**
     * Retrieve a list of UserOAuthTokens that match the criteria.
     * @param predicate the interface for Boolean typed expressions.
     * @return list of UserOAuthToken that match the filter criteria
     */
    List<UserOAuthToken> retrieveToken(Predicate predicate);

    /**
     * If a token is about to expire in the next 5 minutes or if it has already
     * expired, renew the token by calling the Authorization service that issued it.
     * @param userOAuthToken            the authentication token associated with a
     *                                  Dynamo User
     * @param oauthConnectionProperties the properties to hold connection details to
     *                                  an external service
     * @return an non-null UserOAuthToken if present else an empty value
     */
    Optional<UserOAuthToken> renewToken(UserOAuthToken userOAuthToken,
            OAuthConnectionProperties oauthConnectionProperties);

    /**
     * Delete the UserOAuthToken identified by a token ID.
     * @param tokenId the token Id to uniquely identify the token
     * @return true if the token is deleted successfully, else false
     */
    boolean deleteToken(long tokenId);

    /**
     * Delete the UserOAuthToken passed to this method.
     * @param token the token to be deleted
     * @return true if the token is deleted successfully, else false
     */
    boolean deleteToken(UserOAuthToken token);

    /**
     * Retrieve the UserOAuthToken identified by the userIdAtSource property.
     * @param userIdAtSource the property within the UserOAuthToken entity
     * @return a non-null token if the UserOAuthToken is present, else return null
     */
    UserOAuthToken retrieveTokenByUserIdAtSource(String userIdAtSource);
}