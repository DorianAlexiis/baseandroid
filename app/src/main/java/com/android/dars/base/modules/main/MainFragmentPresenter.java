package com.android.dars.base.modules.main;


import com.android.dars.base.data.Addresses;
import com.android.dars.base.data.Contact;
import com.android.dars.base.data.Phone;

import java.util.ArrayList;
import java.util.Arrays;


public class MainFragmentPresenter {

    private MainFragmentView mainFragmentView;
    private ArrayList<Contact> contacts;


    public MainFragmentPresenter() {
        contacts = new ArrayList<>();
        initTest();
    }

    public void setView(MainFragmentView mainFragmentView){
        this.mainFragmentView = mainFragmentView;
    }

    private ArrayList<Addresses> group(Addresses... values) {
        ArrayList<Addresses> addresses = new ArrayList<>();
        addresses.addAll(Arrays.asList(values));
        return addresses;
    }

    private ArrayList<Phone> group(Phone... values) {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.addAll(Arrays.asList(values));
        return phones;
    }

    public void getContacts(){
        mainFragmentView.setContactsAdapter(contacts);
    }


    private void initTest() {
        contacts.add(new Contact("100", "2015-08-05T08:40:51.620Z", "2000-01-31", "Susana", "Ducatti",
                group(
                        new Phone("type","54-11-4787-2012"),
                        new Phone("Cellphone","54-911-3211-0936"),
                        new Phone("Office",null)
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Creative-Tail-People-women-skintone4.svg/128px-Creative-Tail-People-women-skintone4.svg.png",
                "https://image.freepik.com/foto-gratis/primer-plano-de-mujer-joven-al-aire-libre_1098-1638.jpg",
                group(
                        new Addresses(null, "Av. Rivadavia 1001 4B")
                )
        ));


        contacts.add(new Contact("1001", "2014-08-05T08:40:51.620Z", "1995-11-21", "Roberto", "Mancariotti",
                group(
                        new Phone("Home",null),
                        new Phone("Cellphone","54-911-2011-1230"),
                        new Phone("Office",null)
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Creative-Tail-People-man.svg/128px-Creative-Tail-People-man.svg.png",
                "https://static.pexels.com/photos/91227/pexels-photo-91227.jpeg",
                group(
                        new Addresses("Av. Rivadavia 5422 2B", null)
                )
        ));

        contacts.add(new Contact("1002", "1985-08-05T08:40:51.620Z", "1982-11-22", "Nazareno", "Peluffo",
                group(
                        new Phone("Home","54-11-4902-0876"),
                        new Phone("Cellphone",null),
                        new Phone("Office","54-11-4993-3322")
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Creative-Tail-People-police-man.svg/128px-Creative-Tail-People-police-man.svg.png",
                "http://footage.framepool.com/shotimg/qf/884723734-chaqueta-de-punto-apple-ipad-arrugado-sillon.jpg",
                group(
                        new Addresses(null, "La Pampa 1202 3A")
                )
        ));

        contacts.add(new Contact("1003", "2013-08-05T08:40:51.620Z", "1999-03-22", "Luis", "Lopez",
                group(
                        new Phone("Home",null),
                        new Phone("Cellphone",null),
                        new Phone("Office",null)
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Creative-Tail-People-speaker.svg/128px-Creative-Tail-People-speaker.svg.png",
                "http://revistamipediatra.es/images/articulo/294-el-nino-escolar-con-diabetes.jpg",
                group(
                        new Addresses("Av. Mosconi 10 10C", null)
                )
        ));

        contacts.add(new Contact("1004", "2010-08-05T08:40:51.620Z", "1992-11-11", "Ezequiel", "Duran",
                group(
                        new Phone("Home","54-11-4040-2012"),
                        new Phone("Cellphone","54-911-3211-0936"),
                        new Phone("Office","54-11-2333-3333")
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Creative-Tail-People-king.svg/128px-Creative-Tail-People-king.svg.png",
                "https://static.pexels.com/photos/167669/pexels-photo-167669.jpeg",
                group(
                        new Addresses("Echeverria 1010 1A", "Av. Scalabrini Ortiz 100 4B")
                )
        ));

        contacts.add(new Contact("1005", "2015-08-05T08:40:51.620Z", "2000-11-31", "Belen", "Peretti",
                group(
                        new Phone("Home","54-11-4787-2013"),
                        new Phone("Cellphone","54-911-3211-1222"),
                        new Phone("Office",null)
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Creative-Tail-People-doctor.svg/128px-Creative-Tail-People-doctor.svg.png",
                "https://static.pexels.com/photos/206559/pexels-photo-206559.jpeg",
                group(
                        new Addresses("Av. La Plata 112 1B", null)
                )
        ));

        contacts.add(new Contact("1006", "1911-08-05T08:40:51.620Z", "2000-01-11", "Susana", "Traverso",
                group(
                        new Phone("Home",null),
                        new Phone("Cellphone","54-911-1231-0936"),
                        new Phone("Office",null)
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Creative-Tail-People-police-women.svg/128px-Creative-Tail-People-police-women.svg.png",
                "https://static.pexels.com/photos/58020/pexels-photo-58020.jpeg",
                group(
                        new Addresses("Av. La Plata 112 1B", null)
                )
        ));

        contacts.add(new Contact("1007", "2014-04-05T08:40:51.620Z", "1980-01-31", "Carlos", "Rivas",
                group(
                        new Phone("Home","54-11-4322-2221"),
                        new Phone("Cellphone","54-911-2321-3221"),
                        new Phone("Office","53-422-2123")
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Creative-Tail-People-remove-user.svg/128px-Creative-Tail-People-remove-user.svg.png",
                "http://www.dovemen.co/sites/default/files/como-verte-como-el-hombre-moderno_0.png",
                group(
                        new Addresses("Av. Cordoba 1111 1B", null)
                )
        ));

        contacts.add(new Contact("1008", "2013-05-05T08:40:51.620Z", "1976-01-31", "Carolina", "Romero",
                group(
                        new Phone("Home","54-11-4787-2012"),
                        new Phone("Cellphone",null),
                        new Phone("Office",null)
                ),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Creative-Tail-People-women-skintone4.svg/128px-Creative-Tail-People-women-skintone4.svg.png",
                "http://www.mujerespacio.com/wp-content/uploads/2012/11/mujerpelo.jpg",
                group(
                        new Addresses(null, "Av. Medrano 1231 4B")
                )
        ));
    }
}
