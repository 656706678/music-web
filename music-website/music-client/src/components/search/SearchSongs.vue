<template>
  <div class="search-songs">
    <album-content :songList="listOfSongs"></album-content>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { mixin } from '../../mixins'
import AlbumContent from '../AlbumContent'

export default {
  name: 'search-songs',
  components: {
    AlbumContent
  },
  mixins: [mixin],
  computed: {
    ...mapGetters([
      'listOfSongs' // 获取歌单列表
    ])
  },
  mounted () {
    this.getSong()         //mixins->listOfSongs
  }
}
</script>

<style scoped>
  .search-songs{
    min-height: 300px;
  }
</style>
