import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
public interface TFTPProtocol<T>{
    void add (T element ) ;

    T getInstance() ;
    boolean releaseTFTP() ;
    T sendMessage(T element) ;
}


class TFTPProtocolImpl<T> implements TFTPProtocol<T> {
    private List<T> list = new ArrayList<>();

    private static TFTPProtocolImpl instance;
    private static boolean connected = false;
    public boolean isConnected() {
        return connected;
    }
    /**
     *
     */


    /**
     *
     * @return
     */
    public static TFTPProtocol getTFTPInstance() {
        if (instance == null) {
            instance = new TFTPProtocolImpl();
        }
        return instance;
    }

    @Override
    public void add(T element) {
        list.add(element) ;
    }

    @Override
    public T getInstance() {
        return null;
    }

    public boolean releaseTFTP() {
        if(instance != null) {
            instance = null;
            return true;
        }
        return false;
    }

    @Override
    public T sendMessage(T element) {
        return null;
    }

    public void sendMessage(String message) {
        System.out.println("I am sending a " + message + " vi TFTP Protocol");

    }
}

class AdapterClient {
    public static void main(String[] args) {
        //Collection 1 (part I)
        TFTPProtocol<String> randomAccessCollection = new TFTPProtocolImpl<>();
        randomAccessCollection.add("TFTP");

        System.out.println(TFTPProtocolImpl.getTFTPInstance());

    }
}
