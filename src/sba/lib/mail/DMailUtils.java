/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.mail;

import java.util.Base64;

/**
 *
 * @author Sergio Flores
 */
public abstract class DMailUtils {
    
    /**
     * Encondes raw text for subject into an UTF-8 encoded and properly enclosed string ready to be used in mailing.
     * @param subject
     * @return 
     */
    public String encodeSubjectUtf8(final String subject) {
        return DMailConsts.SUBJECT_ENC_UTF8_BEGIN + 
                Base64.getEncoder().encodeToString(subject.getBytes()) + 
                DMailConsts.SUBJECT_ENC_UTF8_END;
    }
}
