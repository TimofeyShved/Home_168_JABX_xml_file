package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.security.MessageDigest;

public class Main {

    public static void main(String[] args) throws JAXBException {
	    // Работаем с XML файлом
        Main.JaxbWriter(); // создаем и записываем в него
    }

    public static void JaxbWriter() throws JAXBException {
        // берем класс с анотациями и записываем в него данные
        CustomerXML customer = new CustomerXML();
        customer.setId(1);
        customer.setName("Tom");
        customer.setAge(28);

        // создаём файл
        File file = new File("C:/Users/Admin/IdeaProjects/Home_168_JABX_xml_file/file.xml");
        // Создаем объект формата с пометками для XML
        JAXBContext context = JAXBContext.newInstance(CustomerXML.class);
        Marshaller marshaller = context.createMarshaller(); // наш объект переводит в XML

        // для того что-бы не в одну строчку
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // записали (сохранили), вывели на экран
        marshaller.marshal(customer, file);
        marshaller.marshal(customer, System.out);
    }
}


