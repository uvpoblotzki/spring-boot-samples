<!DOCTYPE html>
<html>
<head>
  <title>Play the NumberGuesser</title>
</head>
<body>

  <h1>Play the NumberGuesser!</h1>
  <p id="message"></p>

  <form id="start_game_form">
    <button type="submit" title="Start Game!">Start Game!</button>
  </form>

  <form id="guesser_form" style="display: none;">
    <input name="guess" type="number">
    <button type="submit" title="Guess">Guess</button>
  </form>

<script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
  var gameUrl;

  $(function() {
    // add listener an new game form
    $('#start_game_form').on("submit", function(event) {
      event.preventDefault();
      $.ajax({
        method: 'POST',
        url: '',
        dataType: 'json',
        success: function(data, status) {
          gameUrl = data.gameURL;
          $('#start_game_form').hide();
          $('#guesser_form').show();
          $('#message').text("Try to guess the number");
        }
      });
    });

    // add listener to guesser form
    $('#guesser_form').on("submit", function(event) {
      event.preventDefault();
      $.ajax({
        method: 'GET',
        url: '/guesser/' + gameUrl + '/guess',
        data: $('#guesser_form').serialize(),
        success: function(data, status) {
          $('#message').text(data.hint);
          if (data.match) {
            $('#guesser_form').hide();
            $('#start_game_form').show();
          }
        }
      });
    });
  });
</script>
</body>
</html>
