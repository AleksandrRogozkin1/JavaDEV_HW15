package com.goit.hw11.testapp.Services;

import com.goit.hw11.testapp.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
   List<Note> notes=new ArrayList<>();


   public Note createClient(Note note) {
      Long id = note.getId();
      if (notes.contains(id)) {
         throw new IllegalArgumentException("Client already created");
      }else {
         id=getMaxId()+1;
         note.setId(id);
         notes.add(note);
      }
      System.out.println("Client has been added!");
      return note;

   }

   public Note getById(long id) {
return null;
   }

   public void updateClient(Note client) {
      System.out.println("Client has been updated!");
   }

   public void deleteById(Integer id) {
      System.out.println("Client has been deleted!");
   }
   private Long getMaxId(){
      return notes.stream().max(Comparator.comparing(Note::getId)).get().getId();
   }
}
