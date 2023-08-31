<script setup>
import FilmDataService from '../services/FilmDataService';
import {reactive } from 'vue';
import {genres, whereToWatchOptions} from '../functions.js/Options';


const film = reactive({
    id: null,
    title: "",
    date: "",
    genres: genres,
    selectedGenre: "",
    whereToWatchOptions: whereToWatchOptions,
    selectedWheretoWatch: "",
})

function saveFilm() {
    let data = {
        title: film.title,
        date: film.date,
        genre: film.selectedGenre,
        whereToWatch: film.selectedWheretoWatch
    };
    
    FilmDataService.create(data)
        .then(response => {
            film.id = response.data.id;
            console.log(response.data);
        })
        .catch(e => {
            console.log(e);
        });
}

</script>

<template>
  <form >
  <div class="form-group">
    <input type="text" class="form-control" id="title" placeholder="Title" v-model="film.title">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" id="date" placeholder="Year" v-model="film.date">
  </div>
  <div class="form-group">
    <select class="form-control" id="genre" v-model="film.selectedGenre">
        <option value="" disabled>Select a genre</option>
        <option v-for="genre in film.genres" :value="genre" :key="genre">{{ genre }}</option>
    </select>
</div>
  <div class="form-group">
    <select class="form-control" id="whereToWatch" v-model="film.selectedWheretoWatch">
        <option value="" disabled>Select an option</option>
        <option v-for="whereToWatch in film.whereToWatchOptions" :value="whereToWatch" :key="whereToWatch">{{ whereToWatch }}</option>
    </select>
</div>
  <div class="d-flex justify-content-center mt-2">
    <button type="submit" class="btn btn-warning" @click="saveFilm"> Add movie </button>
  </div>

</form>
</template>

<style scoped>

input, select{
  width: 65%;
  margin: auto;
  text-align: center;
}

form{
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 1em;
  margin-top: 1em;
}
</style>