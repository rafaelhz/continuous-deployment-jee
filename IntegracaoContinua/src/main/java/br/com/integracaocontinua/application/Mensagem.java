package br.com.integracaocontinua.application;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe utilitária para a adição das mensagens na tela
 */
public class Mensagem {
    
    public static void adicionarInformacao(String titulo, String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new 
            FacesMessage(FacesMessage.SEVERITY_INFO,titulo,mensagem));  
    }
    
    public static void adicionarAviso(String titulo, String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new 
            FacesMessage(FacesMessage.SEVERITY_WARN,titulo,mensagem));  
    }
    
    public static void adicionarErro(String titulo, String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new 
            FacesMessage(FacesMessage.SEVERITY_ERROR,titulo,mensagem));  
    }
}
