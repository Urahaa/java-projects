package utils;

import model.IdEnum;

public final class GalsUtils {
    
    public static final String HIFEN = " - ";
    public static final String ESPACO = " ";
    public static final String VAZIO = "";
   
    public GalsUtils(){}
    
    public static String converteId(Integer id){
        for (IdEnum idEnum : IdEnum.values()){
            if(idEnum.getId().equals(id)){
                return idEnum.getDescricao();
            }
        }
        return "Símbolo não registrado!";
    }
    
}
