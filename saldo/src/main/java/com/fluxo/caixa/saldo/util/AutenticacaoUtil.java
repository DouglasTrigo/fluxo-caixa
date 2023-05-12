package com.fluxo.caixa.saldo.util;

import org.apache.commons.codec.binary.Base64;

public class AutenticacaoUtil {

    private AutenticacaoUtil(){}

    public static String getCredenciaisBasic(String usuario, String senha){
        String usuarioESenha = usuario + ":" + senha;
        byte[] usuarioESenhaEmBytes = usuarioESenha.getBytes();
        byte[] usuarioESenhaEmBase64 = Base64.encodeBase64(usuarioESenhaEmBytes);
        String base64Creds = new String(usuarioESenhaEmBase64);
        return "Basic " + base64Creds;
    }

}
