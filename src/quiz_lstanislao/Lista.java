/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_lstanislao;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis Stanislao
 */
public class Lista {
    private Nodo pFirst;
    public Lista listaAuxiliar;

//Constructor-----------------------------------------------------
    public Lista() {
        pFirst =null;
    }
//getters and setters----------------------------------------------

    public Nodo getpFirst() {return pFirst;}
    
    public void setpFirst(Nodo pFirst) {this.pFirst = pFirst;}

//----------------------------------------------------------------
    public boolean EsVacio()
    {
        return pFirst==null;  
    }
    
    public Nodo Proximo(Nodo posicion)
    {
        if(posicion.getPnext()!=null)
            {
              posicion=posicion.getPnext();
              return posicion;  
            }  
        else
            {
            return null;
            }
    }
    
    public Nodo Anterior(Nodo posicion)
    {
        Nodo aux = getpFirst();
        Nodo ant = getpFirst();
        
        boolean encontrado = false;
        if(aux==posicion)
        {
            return null;
        }
        else
        {
            while(aux!=null && encontrado==false)
            {
                aux=Proximo(aux);
                if(aux==posicion)
                {
                    encontrado=true;
                    return ant;
                }
                else
                {
                    ant=Proximo(ant);
                }
                
            }  
        }
        return null;
    }
    
    public Nodo getNodo(int pos)
    {
        if(!EsVacio())
        {
            Nodo aux = getpFirst();
            for (int i = 0; i < (pos-1); i++)
            {
                aux=Proximo(aux);
            }
            return aux ;
        }
        else
        {
            
            return null;
        }
    }

    public int getPosicion(Nodo pos)
    {
        if (!EsVacio())
        {
            Nodo aux=getpFirst();
            int cont=0;
            while(aux!=pos)
            {

                cont++;
                aux=Proximo(aux);
            }
        return cont;
        }
        else
        {
            return -1;
        } 
    }
     
    public void Insertar(Object dato ,Nodo apuntando)//PVALOR= EL LUGAR DONDE VAS A INSERTAR
    {
        Nodo pNew = new Nodo(dato);
        Nodo aux=getpFirst();
        if(EsVacio())
        {
            setpFirst(pNew);
        }
        else
        {
            while(aux.getPnext()!=null)
            {
              aux=Proximo(aux);  
            }
            if(apuntando!=null)
            {
                aux.setPnext(pNew);        
                pNew.setPnext(apuntando);    
                
            }
            else
            {
                System.out.println("");
                 aux.setPnext(pNew);
            }
        }
    }
    
    public void Inciar()
    {
        setpFirst(null);
    }
    
    public boolean Evaluar()
    {
        Nodo aux = getpFirst();
        Nodo prev=null ;
        int pos1=0;
        int pos2=0;
        boolean ciclo= false;
        do
        {
            pos1=getPosicion(aux); 
            pos2=getPosicion(aux.getPnext());
            prev=aux;
            aux=Proximo(aux);
        }while(aux.getPnext()!=null && pos1<=pos2);
        
        if(pos1>=pos2)
        {
            ciclo=true;
        }
        return ciclo;
    }
    
    
    public void Mostrar()
    {
       String cadena= "";
       int size=GiveSize();
       Nodo aux=getpFirst();
       for (int i = 0; i <(size); i++) 
       {
            cadena=cadena+"["+aux.getDato()+"], ";
            aux=Proximo(aux);
        }
       JOptionPane.showMessageDialog(null,"La lista: "+cadena);
      
    }
    
    public int GiveSize()
    {
        int pos1=0;
        int pos2=1;
        int cont=1;
        Nodo prev;
        Nodo aux=getpFirst();
        boolean ciclo= false;
        while(aux.getPnext()!=null && pos1<pos2)
        {
            pos1=getPosicion(aux); 
            pos2=getPosicion(aux.getPnext());
            prev=aux;
            cont++;
            aux=Proximo(aux);
        }
        if(pos1>=pos2)
        {
            return (cont-1);
        }
        
        return cont;

    }
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
        /*public Nodo Last()
    {
        Nodo aux = getpFirst();
        int repetido=0;
        while(aux.getPnext()!=null && repetido<2)
        {   
            System.out.println(aux.getDato());
            if(aux==pos)
            {
                System.out.println("pase por aqui "+aux);
                repetido++;
            }
                aux=Proximo(aux);
                size++;   
        }
        
    }

    
    
    
    
    
    public int VerificarNodosRepetidos (Nodo pos)
    {
        int repetido=0;
        Nodo aux = getpFirst();
        System.out.println(aux.getDato()+"hola");
        Nodo ultimo=null;
        Nodo pLast=null;
        int size=0;
        boolean ciclo =false;
        while(pos.getPnext()!=null && repetido!=2)
        {
            while(aux.getPnext()!=null && repetido!=2)
            {   
            System.out.println(aux.getDato()+" "+aux+" VS "+pos.getDato()+" "+pos);
            if(aux==pos)
            {
                System.out.println("pase por aqui "+aux);
                repetido++;
                if (repetido==2)
                {
                    pLast=ultimo;   
                }
            }
                ultimo=aux;
                aux=Proximo(aux);
                size++;   
            }    
        }

            System.out.println(pLast.getDato()+"SIIIII SOY YO");
            return repetido;
    }
    
    public Nodo Recorrido(Lista mylist)
    {
        Lista listica = mylist;
        boolean ciclo = false;
        Nodo aux=listica.getpFirst();
        Nodo last = null;
        while(aux.getPnext()!=null && ciclo==false)
        {
            System.out.print(aux.getDato());
            if(VerificarNodosRepetidos(aux)>1)
            {
                ciclo=true;
                last=aux;
            }
            else
            {
                last=aux;
                aux=Proximo(aux);
            }
        }
        return last;
    }*/
    
    
    
    























}
