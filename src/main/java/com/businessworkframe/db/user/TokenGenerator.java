package com.businessworkframe.db.user;

import java.security.SecureRandom;

/**
 * Java-Klasse zur Token-Generierung
 */
public class TokenGenerator {

    /**
     * Das SecureRandom wird zu Beginn instanziiert.
     */
    protected static SecureRandom random = new SecureRandom();

    /**
     * Methode, die den Token zur Authentifizierung und Autorisierung generiert.
     *
     * @param userid User-Id als Bestandteil des Tokens
     * @return String: Gibt den fertigen Token zurück
     */
    public synchronized String generateToken( String userid ) {
        long longToken = Math.abs( random.nextLong() );
        String random = Long.toString( longToken, 16 );
        return ( userid + ":" + random );
    }
}
