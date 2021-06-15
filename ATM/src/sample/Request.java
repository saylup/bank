package sample;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Request {

    private static final String ip = "tucana.org";
  //ФУ
    public static String checkWorkerFromServer(String log, String pass) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/checkWorker");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Существование пользователя в БД
    public static String checkCustomer(String log, String pass) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/checkCustomer");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String getAwaitingRequests(String log, String pass) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/getAwaitingRequests");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Список счетов
    public static String getAccounts(String log, String pass) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/getAccounts");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Авторизация для банкомата
    public static String getAccount(int numberCard, int pinCode) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/getAccount");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(numberCard + "\n");
        htmlBuilder.append(pinCode);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "denied";
    }
//Стори
    public static String getOperations(String log, String pass) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/getOperations");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String getAwaitingOperations(String log, String pass) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/getAwaitingOperations");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Регистрация пользователя
    public static String addRequest(String request) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/addRequest");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(request);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String addUser(String log, String pass, String request) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/addUser");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(request);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Создание счёта
    public static String addAccount(String log, String pass, String type, float limit) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/addAccount");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(type + "\n");
        htmlBuilder.append(limit);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Пополнение деняк
    public static String addMoney(int numberCard, int pinCode, float sum) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/addMoney");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(numberCard + "\n");
        htmlBuilder.append(pinCode + "\n");
        htmlBuilder.append(sum);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "denied";
    }
//Withdraw
    public static String deleteMoney(int numberCard, int pinCode, float sum) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/deleteMoney");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(numberCard + "\n");
        htmlBuilder.append(pinCode + "\n");
        htmlBuilder.append(sum);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "denied";
    }

    public static String rejectRequest(String log, String pass, String request) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/rejectRequest");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(request);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Перевод между своими счетами
    public static String internalTransfer(String log, String pass, int startAcc, int endAcc, float sum) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/internalTransfer");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(startAcc + "\n");
        htmlBuilder.append(endAcc + "\n");
        htmlBuilder.append(sum);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
//Перевод другому человку
    public static String externalTransfer(String log, String pass, int startAcc, int endAcc, float sum) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/externalTransfer");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(startAcc + "\n");
        htmlBuilder.append(endAcc + "\n");
        htmlBuilder.append(sum);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String acceptOperation(String log, String pass, int id) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/acceptOperation");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(id);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String rejectOperation(String log, String pass, int id) throws IOException {
        /**
         * открываем соединение по данному адресу (пока что это мой айпишник, потом поменяем на адрес сервера)
         */
        URL url = new URL("http://" + ip + ":3300/bank-server/rejectOperation");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /**добавляем логин и пароль в тело запроса, так как передавать их в url выглядит небезопасно ))
         * Внимание! данные строки автоматически меняют тип запроса на POST
         */
        con.setDoOutput(true);
        OutputStream stream = con.getOutputStream();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(log + "\n");
        htmlBuilder.append(pass + "\n");
        htmlBuilder.append(id);
        byte[] bytes = htmlBuilder.toString().getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
        stream.flush();
        stream.close();

        /**
         * считываем ответ сервера, и, если все прошло без выпендрежей, возвращаем ответ сервера
         * иначе возвращаем пустую строку
         */
        try (Scanner in = new Scanner(con.getInputStream())) {
            StringBuilder content = new StringBuilder();
            while (in.hasNextLine()) {
                content.append(in.nextLine());
            }
            return content.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
