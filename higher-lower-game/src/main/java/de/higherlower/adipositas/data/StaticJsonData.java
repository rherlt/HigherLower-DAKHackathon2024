package de.higherlower.adipositas.data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.antlr.v4.runtime.misc.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Optional;
import java.util.Random;

public class StaticJsonData {
    public static Pair<OptionModel, OptionModel> getTwoOptions() {
        // Die JSON-String, den Sie parsen möchten
        String jsonData = """
                        [
                            {
                                "product": "Brot",
                                "calories": 265,
                                "description": "Brot ist der Marathonläufer deines Frühstücks – vollgepackt mit Kohlenhydraten, ein bisschen Fett und ein ordentlicher Schub an Protein, um dich durch den Tag zu bringen. Es läuft quasi mit Kohlenhydraten als Treibstoff.",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiuog8OWc/hZNQEk/2xreafYGG3EbhTwQOMHn5s+gbpQBy9FdRF4Tt5ryztF1XE95EtxArW5/1ZAJ3EEgNjfgcj5eoyKksvDtjFNdi7lkmibSjfW7LHhlB7kbvvD+7kg56igDk6Kmurd7W6kgeOVCh+7NHsfHbK9uMGoaACiiigAooooAKKKKACiiigAqx9vvPsf2P7XP9l/54+YdnXP3enXmq9FAFqbUr+4kiknvbmV4jujZ5WYoeOQSeOg/Km/b7z7Z9s+1z/av+e3mHf0x97r04qvRQA6SR5ZGkkdndyWZmOSSepJptFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB//Z"
                            },
                            {
                                "product": "Käse",
                                "calories": 402,
                                "description": "Käse ist der Rockstar der Milchprodukte – er strotzt vor Fett und Protein, während die Kohlenhydrate im Hintergrund ein bisschen Bass spielen. Fett und Protein sind hier die Headliner!",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiukXw9bnwtDqyieWZ4pWaJJFBUq4UPjGSgGd2OclegyQAc3RXUXfhhYYLKSW5gtUe4W3meRWBQlFIJG48HBPzBCC3IA+7J/whREsryX3lWMaIwupEQLJubAKnft2455YHkfLyKAOToqSeLyLiWHzI5PLcrvjOVbBxkHuKjoAKKKKACiiigAooooAKKKKACrUWpX8EcUcV7cxpES0apKwCE5yQM8dT+ZqrRQBof27rH/QVvv8AwIf/ABqP+1tS+0faP7Qu/P2bPM85t23OcZznGecVTooAdJI8sjSSOzu5LMzHJJPUk02iigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA/9k="
                            },
                            {
                                "product": "Wurst",
                                "calories": 400,
                                "description": "Wurst ist die Partykanone im Brötchen! Mit viel Fett und Protein bringt sie die Party in Schwung, während die Kohlenhydrate im Hintergrund dezent mitfeiern.",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiium03w9Z3GjpqtzLKLVATcGOVAVI83KgHvxDgHrv/ACAOZorqrnwclrcrE+oMQb9LLcsHd4w4bG71IGPx9qhg8NWM19LY/wBtxi6i3I8Xk4LyDaNsZZgG5JHJByOmDmgDm6K6qTw7BHoEuYLw6ml+0ChYMu2ELBdofGCMNuGfbI5PK0AFFFFABRRRQAUUUUAFFFFABUgnmWEwrLIIjnKBjtOcE8f8BX/vkelR0UAXo9a1WKNY49TvERAFVVnYAAdABmmpq2pRzSTJqF2ssuPMdZmDPjgZOecVTooAsLf3iefsu51+0Z87EhHm5znd69T19TVeiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA//Z"
                            },
                            {
                                "product": "Schinken",
                                "calories": 145,
                                "description": "Schinken ist der elegante Cousin der Wurst – schlanker mit Fett, aber vollgepackt mit Protein und nur einem Hauch von Kohlenhydraten. Schinken ist die proteinreiche Alternative für den feinen Geschmack.",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiuisNDsrrQZbvzZZLuOCSd4Qwj2IMhWAZcSDIO4hhjpyeCAc7RXaad4UtrbXoLO9P2tWcwzqYpEVH8rzAUcHB9OcH/Z7inY+G7c67ZWctz5i3lutxb74DtZSrHDhZAVI29ic0AcvRXRW/hsSaZHqUdwsgNs90IZYyobymAkUkNkdRgjrz92tLWPB8C+I7eytJfIW8f90hRmVI1QFiXJ5bIPy/TJGRQBxdFdRF4Tt52bydWjkRXhDmNFfaJTtAO1yNwbgjOMcgnpXO3ds9neT2shUvDI0bFehIODj8qAIaKKKACiiigAooooAKsfb7z7H9j+1z/Zf+ePmHZ1z93p15qvRQBaGpX4aBhe3IMAKwnzW/dgjGF54444p0eralDjytQu0wioNszD5RnA69Bk4HvVOigC0dSv2Uqb25IIdSDK3Ic5Yde55PrTjq2pHdnULs7nDtmZuWGME89RtHPsPSqdFAFxtW1J2LPqF2zHbkmZiTtOV79jyPQ1VkkeWRpJHZ3clmZjkknqSabRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB/9k="
                            },
                            {
                                "product": "Joghurt",
                                "calories": 59,
                                "description": "Joghurt ist wie der sanfte Yoga-Lehrer deines Kühlschranks – leicht, erfrischend und voller Proteine, mit wenig Fett und einer kleinen Portion Kohlenhydrate. Ein perfekt ausbalancierter Snack.",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiityz0i3fw5f6jcpOJYUR4dkqhXDuUBI2k8Mrd+fbrQBh0V1jeB5hdQW6X0ZdrgW8xMZARvKEpK8/MNuRzt5A9cixZeFrJ9MlSd8yzJbS29yqHcgmkKgFd+08AZ9Nx5OBQBxdFdRL4P8q2aU32WS3uZXXyeN0LBWUHdyCScH0HTngh8PaZBqOmx3WoyOLzypYoRbkF43KgBju+UnLdCcBSc5IFAHL0Vqa9p8dhqcy28c62plkWMyR7VyrEFVOTuA4GevqKy6ACiiigAooooAKKKKACpmu7l7VLVriVrdDuWIuSinnkDoOp/OoaKALkWp3KzWzzSSXC23+pjllfanptwwK4wOhHQVYvvEGpX9wJmuJIsIiBYnYDCHK5JJJIJJySTk1l0UAXItW1KDf5OoXcfmOXfZMw3MepODyfeo7q/vL3Z9ru57jZnb5shfbnrjP0FV6KAJrm7ubyQSXVxLO4G0NK5YgemT9ahoooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA//Z"
                            },
                            {
                                "product": "Eier",
                                "calories": 155,
                                "description": "Eier sind kleine Kraftpakete – mit Fett und Protein geben sie dir die Power, die du brauchst, während sie nur wenige Kohlenhydrate enthalten. Protein ist hier der Hauptakteur.",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiui/sS0XwxbaiFuZbqaOVzGjnChG27sCM8DIJyy+xoA52iumTw5FfLokdnOoF+Zv3skRV8Iedw3sDwDjGPf1EcXhq2mvJ4E1aJkithdGVEDhUBw4baxwy9cDOfUUAc7RU11HBHcFbadposKQ7JsPIBIIyehyOp6VDQAUUUUAFFFFABRRRQAUUUUAFWk1K/jtTape3K25BXyllYJg9RjOOcmqtFAF59a1WRQr6neMAQ2GnY8g5B69iAaBrWqiRpBqd4HYBS3ntkgZwM57ZP5mqNFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAf/2Q=="
                            },
                            {
                                "product": "Tomaten",
                                "calories": 18,
                                "description": "Tomaten sind die Supermodels des Gemüsegartens – hübsch, schlank, mit nur wenigen Kohlenhydraten und kaum Fett, dazu ein wenig Protein. Kohlenhydrate und Fett halten sich hier zurück.",
                                "imageBase64": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiityHT9N/4RY6nOLvz/tDWwCSLt3bCytgrnGcAjPqfagDDorrJPBkdsxFzqflrG7RzMtvuCOIhKcfNkrt3c8HIHHPDY/BofVJrUakphQLiYQkZYyGIggkAYZW/iyccA9gDlaK6g+H7dfD03yTy6nHqD22YIi+4qhO0DcPl4zuxkelSP4KVL2Ox/taA3j5XygASH8veOA2dnBG4gHOPlIOaAOTorQ1bTP7Mmtws3mxXFulxGxXa21uxGTg8HoTWfQAUUUUAFFFFABRRRQAVY+33n2P7H9rn+y/88fMOzrn7vTrzVeigCw9/eSLGr3c7LEhSMNISEUjBA9ARxj0qSPVtSiZmj1C7Rm+8VmYE8k88+rMfqT61TooAtHUr8tOxvbkmcBZj5rfvABjDc88cc05dW1JViVdQuwsP+rAmbCcY4544JHHY1TooAklnmn2edLJJ5aBE3sTtUdAM9B7VHRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB//Z"
                            }
                        ]
                """;

        ObjectMapper mapper = new ObjectMapper();

        try {
            OptionModel[] optionModels = mapper.readValue(jsonData, OptionModel[].class);

            // Das JSON-Array aus dem String erstellen
            JSONArray jsonArray = new JSONArray(jsonData);

            Random random = new Random(); // Ein Random-Objekt erstellen
            var random1 = random.nextInt(jsonArray.length());
            var random2 = random.nextInt(jsonArray.length());

            return new Pair<>(optionModels[random1], optionModels[random2]);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}